package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    String pathway = "";
   
    public Path(String path){
        this.pathway = path;

    }

    public Path(){
        
    }

    public void add(String str){
        this.pathway += str;
    }

    public void CanonicalToFactorized(){
        String sections[] = this.pathway.split(" ");
        String factorizedpath = "";
        for (String section : sections){
            Integer count = section.length();
            if (count == 1){
                factorizedpath+=section;
            }else{
                factorizedpath+= count.toString();
                factorizedpath+= String.valueOf(section.charAt(0));
            }
            factorizedpath += " ";
             // Start counting the first character in the section
        }
        this.pathway = factorizedpath.trim();
    }

    public void factorizedtoCanonical(){
        String sections[] = this.pathway.split(" ");
        String canonical = "";
        for (String section : sections){
            boolean hasDigit = section.substring(0, 1).matches("\\d");
            
           
            String dir = section.substring(section.length()-1,section.length());
            if (hasDigit){
                
                System.out.println(dir + "dir");
                String number = section.substring(0,section.length()-1);
                System.out.println(number + "num");
                for(int i = 0; i< Integer.parseInt(number); i++){
                    canonical += dir;
                }
            }else{
                //String dir = section.substring(0,1);
                canonical += dir;
            }
            canonical += " ";
        }
        this.pathway = canonical;

    }
    @Override
    public String toString() {
        return pathway;
    }


}
