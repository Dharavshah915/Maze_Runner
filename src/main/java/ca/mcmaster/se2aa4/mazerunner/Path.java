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

    public String CanonicalToFactorized(){
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
        return factorizedpath.trim();
    }
    @Override
    public String toString() {
        return pathway;
    }


}
