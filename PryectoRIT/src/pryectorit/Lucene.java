/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer.TokenStreamComponents;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.snowball.SnowballFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.Token;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.tartarus.snowball.ext.EnglishStemmer;
import org.tartarus.snowball.ext.LithuanianStemmer;
import org.tartarus.snowball.ext.SpanishStemmer;
/**
 *
 * @author AARON
 */
public class Lucene {
    
    private String[] stopwords = {"a", "acá", "ahí", "ajena", "ajenas", "ajeno", "ajenos", "al", "algo", "algún", "alguna", "algunas", "alguno", "algunos", "allá", "alli", "allí", "ambos", "ampleamos", "ante",
    "antes", "aquel", "aquella", "aquellas", "aquello", "aquellos", "aqui", "aquí", "arriba", "asi", "atras", "aun", "aunque", "bajo", "bastante", "bien", "cabe", "cada", "casi",
    "cierta", "ciertas", "cierto", "ciertos", "como", "cómo", "con", "conmigo", "conseguimos", "conseguir", "consigo", "consigue", "consiguen", "consigues", "contigo", "contra",
    "cual", "cuales", "cualquier", "cualquiera", "cualquieras", "cuan", "cuán", "cuando", "cuanta", "cuánta", "cuantas", "cuántas", "cuanto", "cuánto", "cuantos", "cuántos", "de",
    "dejar", "del", "demás", "demas", "demasiada", "demasiadas", "demasiado", "demasiados", "dentro", "desde", "donde", "dos", "el", "él", "ella", "ellas", "ello", "ellos", "empleais",
    "emplean", "emplear", "empleas", "empleo", "en", "encima", "entonces", "entre", "era", "eramos", "eran", "eras", "eres", "es", "esa", "esas", "ese", "eso", "esos", "esta", "estaba",
    "estado", "estais", "estamos", "estan", "estar", "estas", "este", "esto", "estos", "estoy", "etc", "fin", "fue", "fueron", "fui", "fuimos", "gueno", "ha", "hace", "haceis", "hacemos",
    "hacen", "hacer", "haces", "hacia", "hago", "hasta", "incluso", "intenta", "intentais", "intentamos", "intentan", "intentar", "intentas", "intento", "ir", "jamás", "junto", "juntos",
    "la", "largo", "las", "lo", "los", "mas", "más", "me", "menos", "mi", "mía", "mia", "mias", "mientras", "mio", "mío", "mios", "mis", "misma", "mismas", "mismo", "mismos", "modo",
    "mucha", "muchas", "muchísima", "muchísimas", "muchísimo", "muchísimos", "mucho", "muchos", "muy", "nada", "ni", "ningun", "ninguna", "ningunas", "ninguno", "ningunos", "no", "nos",
    "nosotras", "nosotros", "nuestra", "nuestras", "nuestro", "nuestros", "nunca", "os", "otra", "otras", "otro", "otros", "para", "parecer", "pero", "poca", "pocas", "poco", "pocos",
    "podeis", "podemos", "poder", "podria", "podriais", "podriamos", "podrian", "podrias", "por", "por qué", "porque", "primero", "puede", "pueden", "puedo", "pues", "que", "qué", "querer",
    "quien", "quién", "quienes", "quienesquiera", "quienquiera", "quiza", "quizas", "sabe", "sabeis", "sabemos", "saben", "saber", "sabes", "se", "segun", "ser", "si", "sí", "siempre",
    "siendo", "sin", "sín", "sino", "so", "sobre", "sois", "solamente", "solo", "somos", "soy", "sr", "sra", "sres", "sta", "su", "sus", "suya", "suyas", "suyo", "suyos", "tal", "tales",
    "también", "tambien", "tampoco", "tan", "tanta", "tantas", "tanto", "tantos", "te", "teneis", "tenemos", "tener", "tengo", "ti", "tiempo", "tiene", "tienen", "toda", "todas", "todo",
    "todos", "tomar", "trabaja", "trabajais", "trabajamos", "trabajan", "trabajar", "trabajas", "trabajo", "tras", "tú", "tu", "tus", "tuya", "tuyo", "tuyos", "ultimo", "un", "una", "unas",
    "uno", "unos", "usa", "usais", "usamos", "usan", "usar", "usas", "uso", "usted", "ustedes", "va", "vais", "valor", "vamos", "van", "varias", "varios", "vaya", "verdad", "verdadera",
    "vosotras", "vosotros", "voy", "vuestra", "vuestras", "vuestro", "vuestros", "y", "ya", "yo"};
    
    private StandardAnalyzer analyzer = new StandardAnalyzer();
    
    public Lucene(){
        
    
    }
    
    public ArrayList<String> buscar(String path, String busqueda) throws ParseException, IOException{
        
        SpanishAnalyzer analyzerspanish = new SpanishAnalyzer();
        
        ArrayList<String> escalafon = new ArrayList<String>();
        String INDEX_DIRECTORY = path;
        Directory index = FSDirectory.open(Paths.get(INDEX_DIRECTORY));
        
        String querystr = busqueda;

        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
        Query q = new QueryParser("body", analyzerspanish).parse(querystr);
        
         
      /*  BooleanClause bclause = new BooleanClause(q,BooleanClause.Occur.SHOULD);
        
        BooleanClause bclause2 = new BooleanClause(q,BooleanClause.Occur.SHOULD);
        
        BooleanClause[] clause = new BooleanClause[2];
        
        clause[0]=bclause;
        clause[1]=bclause2;
        
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        
        booleanQuery.add(bclause);
        booleanQuery.add(bclause2);.build()*/
        
        
        // 3. search
        int hitsPerPage = 100;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            //System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
            System.out.println((i + 1) + " " + d.get("titleOriginal"));
            String posicion = d.get("titleOriginal")+",,,"+d.get("pinicial")+",,,"+d.get("pfinal");
            escalafon.add(posicion);
        }

        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
        
        return escalafon;
    }
    
    
    public void indexar(IndexWriter w, String tituloOriginal, String title, String body, String a, String h, String pinicial, String pfinal) throws IOException{
        
        //Steming body
        
        String result = "";
        TokenStream stream  = analyzer.tokenStream(null, new StringReader(body));
        stream.reset();
              
        CharArraySet stopw = new CharArraySet(Arrays.asList(stopwords), true);
        
        //StopAnalyzer Stopanalyzer = new StopAnalyzer(stopw);
        stream = new StopFilter(stream, stopw);
        stream = new SnowballFilter(stream, new SpanishStemmer());
        result = "";
        while (stream.incrementToken()) {
            result += stream.getAttribute(CharTermAttribute.class).toString();
            result+=" ";
            
        }
        System.out.println(result);
        body = result;
        stream.close();
        
        //Steming h
        
        result = "";
        stream  = analyzer.tokenStream(null, new StringReader(h));
        stream.reset();      
        //StopAnalyzer Stopanalyzer = new StopAnalyzer(stopw);
        stream = new StopFilter(stream, stopw);
        stream = new SnowballFilter(stream, new SpanishStemmer());
        result = "";
        while (stream.incrementToken()) {
            result += stream.getAttribute(CharTermAttribute.class).toString();
            result+=" ";
            
        }
        System.out.println(result);
        h = result;
        stream.close();
        
        //System.out.println(title);

        addDoc(w, tituloOriginal, title, body, a, h, pinicial, pfinal);
        
    }
    
    

    public void addDoc(IndexWriter w, String titleOriginal, String title, String body, String a, String h, String pinicial, String pfinal) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        doc.add(new StringField("a", a, Field.Store.YES));
        doc.add(new TextField("h", h, Field.Store.YES));
        doc.add(new TextField("body", body, Field.Store.YES));
        doc.add(new StringField("pinicial", pinicial, Field.Store.YES));
        doc.add(new StringField("pfinal", pfinal, Field.Store.YES));
        doc.add(new StringField("titleOriginal", titleOriginal, Field.Store.YES));

        // use a string field for isbn because we don't want it tokenized
        //doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }
    
    public String stemQuery(String query) throws IOException{
        String[] queryr = query.split(" ");
        for (int i=0; i<queryr.length;i++){
            if (queryr[i].indexOf(":")>=0){
                String[] palabra = queryr[i].split(":");
                palabra[1] = stemWord(palabra[1]);
                queryr[i] = palabra[0]+":"+palabra[1];
            }
        }
        
        return query;
    }
    
    public String stemWord(String palabra) throws IOException{
        String result = "";
        TokenStream stream  = analyzer.tokenStream(null, new StringReader(palabra));
        stream.reset();
              
        CharArraySet stopw = new CharArraySet(Arrays.asList(stopwords), true);
        
        //StopAnalyzer Stopanalyzer = new StopAnalyzer(stopw);
        stream = new StopFilter(stream, stopw);
        stream = new SnowballFilter(stream, new SpanishStemmer());
        result = "";
        while (stream.incrementToken()) {
            result += stream.getAttribute(CharTermAttribute.class).toString();
            result+=" ";
            
        }
        System.out.println(result);
        palabra = result;
        stream.close();
        return palabra;
    }
    
}
