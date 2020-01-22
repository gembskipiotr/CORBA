/**
 *
 * @author imed
 */
import AdditionApp.*;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
 
class AdditionObj extends AdditionPOA {
  private ORB orb;
 
  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
 
  // implement add() method
  public float[] b_sort(String tab) {
      String delimiter = ",";
      String[] values = tab.split(delimiter);
      System.out.printf(tab);
      float arr[] = new float[values.length];

       for(int i=0; i < values.length;i++){
        arr[i] = parseFloat(values[i]);
  }
       int n = arr.length;
         for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    float temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
     System.out.printf(Arrays.toString(arr));
    return arr;
  }
 
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
}