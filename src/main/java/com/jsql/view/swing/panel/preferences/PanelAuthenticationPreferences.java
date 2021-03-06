package com.jsql.view.swing.panel.preferences;

import java.awt.Dimension;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;

import com.jsql.model.MediatorModel;
import com.jsql.view.swing.HelperUi;
import com.jsql.view.swing.panel.PanelPreferences;
import com.jsql.view.swing.text.JPopupTextField;
import com.jsql.view.swing.text.listener.DocumentListenerTyping;

@SuppressWarnings("serial")
public class PanelAuthenticationPreferences extends JPanel {

    private final JCheckBox checkboxUseDigestAuthentication = new JCheckBox("", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().isDigestAuthentication());
    private final JCheckBox checkboxUseKerberos = new JCheckBox("", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().isKerberos());

    private final JTextField textDigestAuthenticationUsername = new JPopupTextField("Host system user", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().getUsernameDigest()).getProxy();
    private final JTextField textDigestAuthenticationPassword = new JPopupTextField("Host system password", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().getPasswordDigest()).getProxy();
    private final JTextField textKerberosLoginConf = new JPopupTextField("Path to login.conf", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().getPathKerberosLogin()).getProxy();
    private final JTextField textKerberosKrb5Conf = new JPopupTextField("Path to krb5.conf", MediatorModel.model().getMediatorUtils().getAuthenticationUtil().getPathKerberosKrb5()).getProxy();

    public PanelAuthenticationPreferences(PanelPreferences panelPreferences) {

        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        GroupLayout groupLayoutAuthentication = new GroupLayout(this);
        this.setLayout(groupLayoutAuthentication);

        // Digest label
        JLabel labelDigestAuthenticationUsername = new JLabel("Username  ");
        JLabel labelDigestAuthenticationPassword = new JLabel("Password  ");
        final JButton labelUseDigestAuthentication = new JButton("Enable Basic, Digest, NTLM");
        String tooltipUseDigestAuthentication =
            "<html>"
            + "Enable <b>Basic</b>, <b>Digest</b>, <b>NTLM</b> authentication (e.g. WWW-Authenticate).<br>"
            + "Then define username and password for the host.<br>"
            + "<i><b>Negotiate</b> authentication is defined in URL.</i>"
            + "</html>";
        labelUseDigestAuthentication.setToolTipText(tooltipUseDigestAuthentication);
        
        // Proxy setting: IP, port, checkbox to activate proxy
        this.getCheckboxUseDigestAuthentication().setToolTipText(tooltipUseDigestAuthentication);
        this.getCheckboxUseDigestAuthentication().setFocusable(false);
        
        // Digest label
        JLabel labelKerberosLoginConf = new JLabel("login.conf  ");
        JLabel labelKerberosKrb5Conf = new JLabel("krb5.conf  ");
        final JButton labelUseKerberos = new JButton("Enable Kerberos");
        String tooltipUseKerberos =
            "<html>"
            + "Activate Kerberos authentication, then define path to <b>login.conf</b> and <b>krb5.conf</b>.<br>"
            + "Path to <b>.keytab</b> file is defined in login.conf ; name of <b>principal</b> must be correct.<br>"
            + "<b>Realm</b> and <b>kdc</b> are defined in krb5.conf.<br>"
            + "Finally use the <b>correct hostname</b> in URL, e.g. http://servicename.corp.test/[..]"
            + "</html>";
        labelUseKerberos.setToolTipText(tooltipUseKerberos);
        
        // Proxy setting: IP, port, checkbox to activate proxy
        this.getTextKerberosLoginConf().setToolTipText(
            "<html>"
            + "Define the path to <b>login.conf</b>. Sample :<br>"
            + "&emsp;<b>entry-name</b> {<br>"
            + "&emsp;&emsp;com.sun.security.auth.module.Krb5LoginModule<br>"
            + "&emsp;&emsp;required<br>"
            + "&emsp;&emsp;useKeyTab=true<br>"
            + "&emsp;&emsp;keyTab=\"<b>/path/to/my.keytab</b>\"<br>"
            + "&emsp;&emsp;principal=\"<b>HTTP/SERVICENAME.CORP.TEST@CORP.TEST</b>\"<br>"
            + "&emsp;&emsp;debug=false;<br>"
            + "&emsp;}<br>"
            + "<i>Principal name is case sensitive ; entry-name is read automatically.</i>"
            + "</html>");
        this.getTextKerberosKrb5Conf().setToolTipText(
            "<html>"
            + "Define the path to <b>krb5.conf</b>. Sample :<br>"
            + "&emsp;[libdefaults]<br>"
            + "&emsp;&emsp;default_realm = <b>CORP.TEST</b><br>"
            + "&emsp;&emsp;udp_preference_limit = 1<br>"
            + "&emsp;[realms]<br>"
            + "&emsp;&emsp;<b>CORP.TEST</b> = {<br>"
            + "&emsp;&emsp;&emsp;kdc = <b>127.0.0.1:88</b><br>"
            + "&emsp;&emsp;}<br>"
            + "<i>Realm and kdc are case sensitives.</i>"
            + "</html>");
        this.getCheckboxUseKerberos().setToolTipText(tooltipUseKerberos);
        this.getCheckboxUseKerberos().setFocusable(false);
        
        labelUseKerberos.addActionListener(actionEvent -> {
            this.getCheckboxUseKerberos().setSelected(!this.getCheckboxUseKerberos().isSelected());
            if (this.getCheckboxUseKerberos().isSelected()) {
                this.getCheckboxUseDigestAuthentication().setSelected(false);
            }
            panelPreferences.getActionListenerSave().actionPerformed(null);
        });
        
        labelUseDigestAuthentication.addActionListener(actionEvent -> {
            this.getCheckboxUseDigestAuthentication().setSelected(!this.getCheckboxUseDigestAuthentication().isSelected());
            if (this.getCheckboxUseDigestAuthentication().isSelected()) {
                this.getCheckboxUseKerberos().setSelected(false);
            }
            panelPreferences.getActionListenerSave().actionPerformed(null);
        });
        
        this.getTextKerberosKrb5Conf().setMaximumSize(new Dimension(400, 0));
        this.getTextKerberosLoginConf().setMaximumSize(new Dimension(400, 0));
        this.getTextDigestAuthenticationUsername().setMaximumSize(new Dimension(200, 0));
        this.getTextDigestAuthenticationPassword().setMaximumSize(new Dimension(200, 0));

        this.getTextKerberosLoginConf().setFont(HelperUi.FONT_SEGOE_BIG);
        this.getTextKerberosKrb5Conf().setFont(HelperUi.FONT_SEGOE_BIG);
        
        this.getTextDigestAuthenticationUsername().setFont(HelperUi.FONT_SEGOE_BIG);
        this.getTextDigestAuthenticationPassword().setFont(HelperUi.FONT_SEGOE_BIG);
        
        Stream.of(
            this.getCheckboxUseDigestAuthentication(),
            this.getCheckboxUseKerberos()
        ).forEach(button -> button.addActionListener(panelPreferences.getActionListenerSave()));
        
        DocumentListener documentListenerSave = new DocumentListenerTyping() {
            
            @Override
            public void process() {
                panelPreferences.getActionListenerSave().actionPerformed(null);
            }
        };

        Stream.of(
            this.getTextDigestAuthenticationPassword(),
            this.getTextDigestAuthenticationUsername(),
            this.getTextKerberosKrb5Conf(),
            this.getTextKerberosLoginConf()
        )
        .forEach(textField -> textField.getDocument().addDocumentListener(documentListenerSave));

        Stream.of(
            labelUseDigestAuthentication,
            labelUseKerberos
        )
        .forEach(label -> {
            label.setHorizontalAlignment(SwingConstants.LEFT);
            label.setBorderPainted(false);
            label.setContentAreaFilled(false);
        });
        
        groupLayoutAuthentication.setHorizontalGroup(
            groupLayoutAuthentication
            .createSequentialGroup()
            .addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(this.getCheckboxUseDigestAuthentication())
                .addComponent(labelDigestAuthenticationUsername)
                .addComponent(labelDigestAuthenticationPassword)
                .addComponent(this.getCheckboxUseKerberos())
                .addComponent(labelKerberosLoginConf)
                .addComponent(labelKerberosKrb5Conf)
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup()
                .addComponent(labelUseDigestAuthentication)
                .addComponent(this.getTextDigestAuthenticationUsername())
                .addComponent(this.getTextDigestAuthenticationPassword())
                .addComponent(labelUseKerberos)
                .addComponent(this.getTextKerberosLoginConf())
                .addComponent(this.getTextKerberosKrb5Conf())
            )
        );
        
        groupLayoutAuthentication.setVerticalGroup(
            groupLayoutAuthentication
            .createSequentialGroup()
            .addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.getCheckboxUseDigestAuthentication())
                .addComponent(labelUseDigestAuthentication)
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelDigestAuthenticationUsername)
                .addComponent(this.getTextDigestAuthenticationUsername())
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelDigestAuthenticationPassword)
                .addComponent(this.getTextDigestAuthenticationPassword())
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.getCheckboxUseKerberos())
                .addComponent(labelUseKerberos)
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelKerberosLoginConf)
                .addComponent(this.getTextKerberosLoginConf())
            ).addGroup(
                groupLayoutAuthentication
                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelKerberosKrb5Conf)
                .addComponent(this.getTextKerberosKrb5Conf())
            )
        );
    }
    
    // Getter and setter
    
    public JCheckBox getCheckboxUseDigestAuthentication() {
        return this.checkboxUseDigestAuthentication;
    }

    public JTextField getTextDigestAuthenticationUsername() {
        return this.textDigestAuthenticationUsername;
    }

    public JTextField getTextDigestAuthenticationPassword() {
        return this.textDigestAuthenticationPassword;
    }

    public JCheckBox getCheckboxUseKerberos() {
        return this.checkboxUseKerberos;
    }

    public JTextField getTextKerberosKrb5Conf() {
        return this.textKerberosKrb5Conf;
    }

    public JTextField getTextKerberosLoginConf() {
        return this.textKerberosLoginConf;
    }
}
