import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRBarcodeGenerator {
    public static void main(String[] args) {
        try {
            // Generate QR Code
            String qrData = "https://example.com";
            String qrPath = "output/qrcode.png";
            BitMatrix qrMatrix = new MultiFormatWriter().encode(qrData, BarcodeFormat.QR_CODE, 300, 300);
            Path qrOutputPath = FileSystems.getDefault().getPath(qrPath);
            MatrixToImageWriter.writeToPath(qrMatrix, "PNG", qrOutputPath);
            System.out.println("QR Code generated at " + qrPath);

            // Generate Barcode (Code 128)
            String barcodeData = "1234567890";
            String barcodePath = "output/barcode.png";
            BitMatrix barcodeMatrix = new MultiFormatWriter().encode(barcodeData, BarcodeFormat.CODE_128, 300, 100);
            Path barcodeOutputPath = FileSystems.getDefault().getPath(barcodePath);
            MatrixToImageWriter.writeToPath(barcodeMatrix, "PNG", barcodeOutputPath);
            System.out.println("Barcode generated at " + barcodePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
