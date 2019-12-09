package ftpvfs;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class FTPVFS
{
    private String password = "password";
    private String username = "username";
    private String remoteHost = "";

    public FTPVFS()
    {

    }
    
    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
        Session jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }
    
}
