import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int linhas = 8;
    public static int palavras = 4;

    public static void main(String[] args) throws FileNotFoundException{
        //cria cache Cache(linhas,palavras,direto=true || associativo=false)
        Cache cache = new Cache(linhas, palavras,true);

        //seta scanner pro arquivo que contem os hexas de entrada
        File arq = new File("memory_access.txt");
        Scanner in = new Scanner(arq);
        int  palavrasLidas=0;

        //enquanto houver entradas (hexas), adiciona eles na cache e printa o estado da mesma
        while(in.hasNext()){
            String entrie = in.next();
            //Endereco(hexa, bitsTag, bitsLinha, bitsPalavra, bitsSelecao, converterBinario=true)
            Endereco a = new Endereco(entrie,10,3,2,1,true);
            System.out.println("Execução: " + ++palavrasLidas + "   Endereço recebido: " + entrie);
            cache.add(a);
        }

        //mostra o historico de hits e misses, fecha o scanner e mostra a porcentagem de acerto
        cache.showHistorico();
        in.close();
        double x = cache.percentAcertos()*100;
        System.out.printf("%.2f",x);
        System.out.println("% de acerto na cache.");
    }

}