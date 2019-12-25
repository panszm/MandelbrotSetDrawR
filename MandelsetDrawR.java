import java.awt.*;

class MandelsetDrawR extends Canvas{

    MandellikeSet mls;
    int width = 300;
    int height = 300;
    int mainDim = 0;
    double zoom = 1.0;
    double offsetX = 0;
    double offsetY = 0;

    public void setZoom(double newZoom){
        zoom=newZoom;
    }
    public void setOffsetX(double value){
        offsetX=value;
    }
    public void setOffsetY(double value){
        offsetY=value;
    }

    public MandelsetDrawR(int precision, double bound){
        mls = new MandellikeSet(precision, bound);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        width = getWidth();
        height = getHeight();
        if(width<height){mainDim=width;}else{mainDim=height;}
        double span = mls.bound*2/zoom;
        double pointLength = span/mainDim;
        for(int i = 0;i<mainDim;i++){
            for(int j = 0;j<mainDim;j++){
                if(mls.isIn(-mls.bound+(i+mainDim*(zoom-1)/2)*pointLength+offsetX, mls.bound-(j+mainDim*(zoom-1)/2)*pointLength+offsetY))g.drawRect(((int)(width-mainDim)/2+i),((int)(height-mainDim)/2+j),1,1);
            }
        }

        g.setColor(Color.GREEN);
        g.drawLine(0,height/2,width, height/2);
        g.drawLine(width/2,0,width/2, height);

        g.drawLine((width-mainDim)/2+1,height/2-mainDim/40,(width-mainDim)/2+1, height/2+mainDim/40);
        g.drawLine((width+mainDim)/2-2,height/2-mainDim/40,(width+mainDim)/2-2, height/2+mainDim/40);
        g.drawLine(width/2-mainDim/40,(height-mainDim)/2+1,width/2+mainDim/40, (height-mainDim)/2+1);
        g.drawLine(width/2-mainDim/40,(height+mainDim)/2-2,width/2+mainDim/40, (height+mainDim)/2-2);
        
        g.setFont(new Font("Dialog", Font.PLAIN, 12));
        g.drawString(""+(offsetX+(-1)*mls.bound/zoom),(width-mainDim)/2+mainDim/40,19*(height+mainDim)/80);
        g.drawString(""+(offsetX+mls.bound/zoom),(width+mainDim)/2-mainDim/20,19*(height+mainDim)/80);
        g.drawString(""+(offsetY+mls.bound/zoom),width/2+mainDim/80,(height-mainDim)/2+mainDim/40);
        g.drawString(""+(offsetY+(-1)*mls.bound/zoom),width/2+mainDim/80,(height+mainDim)/2-mainDim/40);
        
        g.drawString("("+offsetX+" ; "+offsetY+")",width/2+mainDim/80,19*(height+mainDim)/80);
    }

}