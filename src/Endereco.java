public class Endereco {
    public String endereco;
    public int tagT;
    public int linhaT;
    public int palavraT;
    public int selecT;

    public Endereco (String address, int tag, int line, int word, int selectByte, boolean addressIsInHexadecimal) {
        tagT = tag;
        linhaT = line;
        palavraT = word;
        selecT = selectByte;

        if (addressIsInHexadecimal)
            endereco = convertToBinary (address);
        else
            endereco = address;

        if(endereco.charAt(15)=='1'){
            String certa = endereco.substring(0,15)+"0";
            endereco=certa;
        }
    }

    public String tag(){
        return endereco.substring (0, tagT);
    }
    public String linha(){
        return endereco.substring (tagT, tagT + linhaT);
    }
    public String palavra(){
        return endereco.substring (tagT + linhaT, tagT + linhaT + palavraT);
    }
    public String selec(){
        return endereco.substring (tagT + linhaT + palavraT, tagT + linhaT + palavraT + selecT);
    }

    public String convertToBinary(String hex) {
        String res = "";
        for(int i = 0; i<hex.length(); i++){
            char a = hex.charAt(i);
            if (a=='0') res+="0000";
            else if (a=='1') res+="0001";
            else if (a=='2') res+="0010";
            else if (a=='3') res+="0011";
            else if (a=='4') res+="0100";
            else if (a=='5') res+="0101";
            else if (a=='6') res+="0110";
            else if (a=='7') res+="0111";
            else if (a=='8') res+="1000";
            else if (a=='9') res+="1001";
            else if (a=='a') res+="1010";
            else if (a=='b') res+="1011";
            else if (a=='c') res+="1100";
            else if (a=='d') res+="1101";
            else if (a=='e') res+="1110";
            else if (a=='f') res+="1111";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Endereço: " + endereco;
    }
}