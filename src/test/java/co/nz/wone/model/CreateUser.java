package co.nz.wone.model;

import lombok.*;

@Data
public class CreateUser {

    private String channel;
    private String userName;
    private String customerId;
    private String password;
    private String givenName;
    private String sn;
    private String mobile;
    private String mail;
    private String custCRSNo;
    private String [] businessMemberships;
}
