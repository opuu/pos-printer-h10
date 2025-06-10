package rocks.opu.posh10;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.sr.SrPrinter;

import recieptservice.com.recieptservice.PrinterInterface;

@CapacitorPlugin(name = "POSH10")
public class POSH10Plugin extends Plugin {

    private final POSH10 implementation = new POSH10();
    private PrinterInterface printer;


    @Override
    public void load() {
        super.load();

        SrPrinter.bindPrinter(getContext(), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                printer = PrinterInterface.Stub.asInterface(
                        service
                );
                Log.i("POSH10", "Service connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("POSH10", "Service disconnected");
            }
        });
    }

    @PluginMethod
    public void getServiceVersion(PluginCall call) {
        try {
            JSObject ret = new JSObject();
            ret.put("version", printer.getServiceVersion());
            call.resolve(ret);
        } catch (RemoteException e) {
            Log.e("POSH10", "Failed to get service version", e);
            call.reject("Failed to get service version");
        }
    }

    @PluginMethod
    public void printText(PluginCall call) {
        String text = call.getString("text");
        try {
            printer.getServiceVersion();
            printer.beginWork();
            printer.setAlignment(1);
            printer.setTextSize(20);
            printer.printText(text);
            printer.nextLine(1);
            printer.endWork();
            JSObject ret = new JSObject();
            ret.put("result", "success");
            call.resolve(ret);
        } catch (RemoteException e) {
            Log.e("POSH10", "Failed to print text", e);
            call.reject("Failed to print text");
        }
    }

    @PluginMethod
    public void printImage(PluginCall call) {
        String encodedImage = call.getString("base64");
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        try {
            printer.beginWork();
            printer.printBitmap(decodedByte);
            printer.nextLine(1);
            printer.endWork();
            JSObject ret = new JSObject();
            ret.put("result", "success");
            call.resolve(ret);
        } catch (RemoteException e) {
            Log.e("POSH10", "Failed to print bitmap", e);
            call.reject("Failed to print bitmap");
        }
    }
}
