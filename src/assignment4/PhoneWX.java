package assignment4;

class PhoneWX extends Phone 
{
   // additional member
   private String extension;
    
   public PhoneWX()
   {
      super();
      extension =  "00";
   }
   public PhoneWX(String ac, String num, String ext)
   {
      super(ac, num);
      
      // now the extension - let mutator do validation
      if ( !setExtension(ext) )
         extension = "00";
   }
   public boolean setPhoneWX(String ac, String num, String ext)
   {
      // first base class stuff
      if ( !setPhone(ac, num) )
         return false;  // don't change anything, return false

      // now the extension
      if ( !setExtension(ext) )
         return false;  // don't change anything, return false
      
      return true;

      // if ac/num were good, but ext was bad, we have a little weirdness -
      // ac/num get changed, but ext doesn't. I'll leave this weakness as
      // an exercise for the reader to fix.
   }
   public String getExtension()
   {
      return extension;
   }
   public boolean setExtension(String ext)
   {
      if (ext.length() == 2 && isNumber(ext) )
      {
         extension = ext;
         return true;
      }
      return false;
   }
   public String toString()
   {
      return "ext. " + extension;
   }
   public void showPhone()
   {
      System.out.println(super.toString()+ "  "  + toString() );
   }
}