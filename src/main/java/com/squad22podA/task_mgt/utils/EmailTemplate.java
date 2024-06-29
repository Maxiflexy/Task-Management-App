package com.squad22podA.task_mgt.utils;

public class EmailTemplate {

    public static String getEmailMessage(String name, String url, String token){

        return "CONGRATULATIONS!!! Your User Account Has Been Successfully Created.\n"
                + "Your Account Details: \n" + "Account FullName: " + name + " \n"
                + "Confirm your email " +
                "Please click the link to confirm your registration: " + getVerificationUrl(url, token);

    }

    public static String getVerificationUrl(String baseurl, String token){

        //return baseurl + "/api/auth/confirm?token=" + token ;
        return baseurl + "/confirmation/confirm-token-sucess.html?token=" + token ;
    }



}
//        EmailDetails emailDetails = EmailDetails.builder()
//                                    .recipient(savedUser.getEmail())
//                                    .subject("ACCOUNT CREATION")
//                                    .messageBody("CONGRATULATIONS!!! Your User Account Has Been Successfully Created.\n"
//                                    + "Your Account Details: \n" + "Account FullName: " + savedUser.getFirstName() + " \n"
//                                     + "Confirm your email " +
//                                            "Please click the link to confirm your registration: " + confirmationUrl)
//                                    .build();

//emailService.sendEmailAlert(emailDetails);

//String confirmationUrl = "http://localhost:8080/api/auth/confirm?token=" + confirmationToken.getToken();
//String confirmationUrl = "http://127.0.0.1:5500/confirmation/confirm-token-sucess.html?token="+ confirmationToken.getToken();