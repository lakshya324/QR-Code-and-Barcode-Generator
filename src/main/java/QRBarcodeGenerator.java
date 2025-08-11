import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRBarcodeGenerator {

    // Hyperparameters for QR code
    public static String qrData = "https://example.com";
    public static String qrOutputPath = "output/qrcode.png";
    public static int qrWidth = 300;
    public static int qrHeight = 300;
    public static String qrImageFormat = "PNG";

    // Hyperparameters for Barcode
    public static String barcodeData = "1234567890";
    public static String barcodeOutputPath = "output/barcode.png";
    public static int barcodeWidth = 300;
    public static int barcodeHeight = 100;
    public static String barcodeImageFormat = "PNG";
    public static BarcodeFormat barcodeFormat = BarcodeFormat.CODE_128;

    public static void main(String[] args) {
        try {
            // Generate QR Code
            BitMatrix qrMatrix = new MultiFormatWriter().encode(qrData, BarcodeFormat.QR_CODE, qrWidth, qrHeight);
            Path qrPath = FileSystems.getDefault().getPath(qrOutputPath);
            MatrixToImageWriter.writeToPath(qrMatrix, qrImageFormat, qrPath);
            System.out.println("QR Code generated at " + qrOutputPath);

            // Generate Barcode
            BitMatrix barcodeMatrix = new MultiFormatWriter().encode(barcodeData, barcodeFormat, barcodeWidth, barcodeHeight);
            Path barcodePath = FileSystems.getDefault().getPath(barcodeOutputPath);
            MatrixToImageWriter.writeToPath(barcodeMatrix, barcodeImageFormat, barcodePath);
            System.out.println("Barcode generated at " + barcodeOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
