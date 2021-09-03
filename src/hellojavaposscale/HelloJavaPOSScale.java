
package hellojavaposscale;

import com.dls.jpos.common.DLSJposConst;
import jpos.Scale;
import java.io.*;

/*
 * HelloJavaPOSScale reads the current scale weight.
 * 
 * The weight of the object on the scale is read if everything works.
 * 1 Device attached
 * 2 Device interface and port name match your chosen
 *   jpos.xml JavaPOSScaleDevice entry.
 * 3 This JavaPOSScaleDevice entry is in the
 *   jpos.xml in the install directory
 *       C:\Program Files\Datalogic\JavaPOS
 *   or
 *       /usr/local/Datalogic/JavaPOS
 * 4 Device is a scale.
 */
public class HelloJavaPOSScale {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Hello message and question.
            System.out.println("Hello JavaPOS Scale.");
            System.out.println("Is anything on the scale?");
            System.out.println("Is the weight read?");

            Scale scaleObj = new Scale();

            // The int array initial value is an impossible weight.
            // The int array's first element returns with the weight.
            int[] intArr = new int[50];
            intArr[0] = -23;

            int intResult = -29;

            scaleObj.open("JavaPOSScaleDevice");

            scaleObj.claim(1000);

            scaleObj.setDeviceEnabled(true);

            scaleObj.readWeight(intArr,intResult);

            // Print the weight read.
            System.out.println(intArr[0]);

            System.out.println("A weight of zero or larger is expected.");

            scaleObj.setDeviceEnabled(false);
            scaleObj.release();
            scaleObj.close();

            // This exit 0 status code indicates normal termination.
            System.exit(0);

        } catch (Exception exp) {
            // Print its stack trace.
            exp.printStackTrace();
            // A non-zero status code indicates abnormal termination.
            System.exit(19);
        }
    }
}
