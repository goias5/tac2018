/**
 * Created by aluno on 07/11/18.
 */
public class Contadores {
    public int contM;
    public int contD;
    public int contC;
    public int contL;
    public int contX;
    public int contV;
    public int contI;

    public Contadores() {
        this.contM = 0;
        this.contD = 0;
        this.contC = 0;
        this.contL = 0;
        this.contX = 0;
        this.contV = 0;
        this.contI = 0;
    }

    public boolean testaContadores(){
        if(contM>4){
            return false;
        }
        if(contD>1){
            return false;
        }
        if(contC>4){
            return false;
        }
        if(contL>1){
            return false;
        }
        if(contX>4){
            return false;
        }
        if(contV>1){
            return false;
        }
        if(contI>4){
            return false;
        }
        return true;
    }
}
