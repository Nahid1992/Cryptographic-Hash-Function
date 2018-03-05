/**
 * a program to experiment with one-way property of cryptographic hash functions
 */

/**
 * @author Nahid Ul Islam cig399
 *
 */
import java.util.*;
import java.security.*;

public class MD5Hash {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
   @SuppressWarnings("resource")
   Scanner sc=new Scanner(System.in);
     
   System.out.println("Enter Number of Bytes to match: ");
   // get input for number of bytes  
   int n=sc.nextInt();
   
   byte b[]=new byte[n];
   System.out.println("Enter the byte values to match for " +n+ " bytes: ");
   // get input for byte values  
   for(int i=0; i<b.length; i++)
   {
   b[i]=sc.nextByte();
   }
     
   String TargetDigestPrefix=convertBytesToHex(b);
   
   System.out.println("TargetDigestPrefix in hexadecimal for "+n+ " bytes: \n" +TargetDigestPrefix);
   
   try {
    
    for(long i=0; ; i++)
    {
     // using MD5 hash
     MessageDigest md = MessageDigest.getInstance("MD5");
              // generating random hexadecimal string
     String input = generateRandomHexString(40);
     md.update(input.getBytes()); 
     byte[] output = md.digest();
     String hash = convertBytesToHex(output);
     
     if(hash.startsWith(TargetDigestPrefix))
     {
      System.out.println("\nMatch in: "+i+" runs");
            System.out.println("Message in hexadecimal format: "+input);
            System.out.println("MD5 Digest in hexadecimal format: "+hash);
            break;
            }
           
        }
    } catch (Exception e) {
          System.out.println("Exception: "+e);
       }
   }
 
 // convert byte array to hexadecimal
 public static String convertBytesToHex(byte[] b) {
  char hexadecimalDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
     
  StringBuffer strbuf = new StringBuffer();
     
  for (int j=0; j<b.length; j++) {
   strbuf.append(hexadecimalDigit[(b[j] >> 4) & 0x0f]);
         strbuf.append(hexadecimalDigit[b[j] & 0x0f]);
         }
  
  return strbuf.toString();
  
    }
 
 // generate random hexadecimal string
 public static String generateRandomHexString(int n){
  Random r = new Random();
     StringBuffer strbuf = new StringBuffer();
        
     while(strbuf.length() < n){
      strbuf.append(Integer.toHexString(r.nextInt()));
      }
     
     return strbuf.toString().substring(0, n);
     
    }

}
