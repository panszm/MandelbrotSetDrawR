class MandellikeSet{
    
    public int precision = 500;
    public double bound = 2;

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setBound(double bound){
        this.bound = bound;
    }

    public MandellikeSet(int precision, double bound){
        this.precision = precision;
        this.bound = bound;
    }

    public boolean isIn(double realPart, double imaginaryPart){
        double currentRealPart = 0.0;
        double currentImaginaryPart = 0.0;
        for(int i = 0;i<precision;i++){
            double dumReal = currentRealPart;
            double dumImaginary = currentImaginaryPart;
            currentRealPart = Math.pow(dumReal,2)-Math.pow(dumImaginary,2);
            currentImaginaryPart = 2.0*dumReal*dumImaginary; 
            currentRealPart += realPart;
            currentImaginaryPart += imaginaryPart;
            if(Math.sqrt(Math.pow(currentRealPart,2)+Math.pow(currentImaginaryPart,2))>bound)return false;
        }

        return true;
    }

}