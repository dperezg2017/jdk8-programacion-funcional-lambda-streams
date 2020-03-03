package com.util;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilitarioZip {

    private static final Logger LOOGER = LoggerFactory.getLogger(UtilitarioZip.class);

    @Test
    public void utilitario_comprimir_descomprimir_zip() {
        try {
            // archivo que extraera
            String zipFilePath = "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/xmlTest4.xml";
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            // ruta a descomprimir
            File rootFolder = new File("/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/comprimir");
            for (File file : rootFolder.listFiles()) {
                writeToZip(file, zos);
                System.out.println("Zipping: " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToZip(File file, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getAbsolutePath());
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0)
            zos.write(bytes, 0, length);

        zos.closeEntry();
        fis.close();
    }

    @Test
    public void utilitario_Deflate_Inflate() {


        try {
            // Encode a String into bytes
            String inputString = "blahblahblah";
            byte[] input = inputString.getBytes("UTF-8");

            // Compress the bytes
            byte[] output = new byte[100];
            Deflater compresser = new Deflater();
            compresser.setInput(input);
            compresser.finish();
            int compressedDataLength = compresser.deflate(output);
            compresser.end();

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(output, 0, compressedDataLength);
            byte[] result = new byte[100];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

            // Decode the bytes into a String
            String outputString = new String(result, 0, resultLength, "UTF-8");
            LOOGER.info("outputString: {}", outputString);
        } catch (java.io.UnsupportedEncodingException ex) {
            // handle
        } catch (java.util.zip.DataFormatException ex) {
            // handle
        }


    }
}
