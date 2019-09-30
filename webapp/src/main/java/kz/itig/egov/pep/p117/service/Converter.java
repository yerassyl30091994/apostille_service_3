package kz.itig.egov.pep.p117.service;

import kz.itig.egov.pep.p117.GetConfirmationResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class Converter {


    public void fromBase64ToPdf() {

        File file = new File("test.pdf");
        try (FileOutputStream fos = new FileOutputStream(file);) {

            String b64Document = "/9j/4AAQSkZJRgABAQEAeAB4AAD/2wBDAAIBAQIBAQICAgICAg…KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigD//2Q==";
            GetConfirmationResponse getConfirmationResponse = new GetConfirmationResponse();

            byte[] decoderDocument = Base64.getDecoder().decode(b64Document);
           fos.write(decoderDocument);

            System.out.println("PDF File Saved");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
