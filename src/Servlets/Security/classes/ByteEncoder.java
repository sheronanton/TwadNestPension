package Servlets.Security.classes;

public class ByteEncoder
{
              public byte[] encode(byte[] b)
              {
                  byte[] bStr=new byte[b.length];
                  for(int i=0;i<b.length;i++)
                  {
                    bStr[i]=0;
                    int tempInt=new Integer(b[i]).intValue();
                    tempInt=tempInt>>1;                    // right shifting once
                    tempInt=47567^tempInt;                  // xor
                    tempInt=tempInt<<3;                    // left shifting thrice
                    bStr[i]=new Integer(tempInt).byteValue();

                  }
                  return bStr;
              }
}