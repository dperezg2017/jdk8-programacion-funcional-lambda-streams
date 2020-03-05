package com.util;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.*;

public class UtilitarioZip {

    private static final Logger LOOGER = LoggerFactory.getLogger(UtilitarioZip.class);

    @Test
    public void comprimir_directorio_zip() throws IOException {
        String sourceFile = "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/";
        FileOutputStream fos = new FileOutputStream("directorioComprimido.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);

        zipFile(fileToZip, fileToZip.getName(), zipOut);
        zipOut.close();
        fos.close();
    }

    @Test
    public void comprimir_file() throws IOException {
        String sourceFile = "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/xmlTest2.xml";
        FileOutputStream fos = new FileOutputStream("FileComprimido.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    @Test
    public void comprimir_files() throws IOException {
        List<String> srcFiles = Arrays.asList(
                "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/fileTest1.xml",
                "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/fileTest2.xml");
        FileOutputStream fos = new FileOutputStream("filesComprimidos.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

    @Test
    public void descomprimir_zip() throws IOException {
        String fileZip = "/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/filesComprimidos.zip";
        File destDir = new File("/Users/deyvisperez/deyvizperez/udemy/jdk8-programacion-funcional-lambda-streams/utilitario-java-11/descomprimir/");
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
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
