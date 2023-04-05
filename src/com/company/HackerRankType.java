package com.company;

public class HackerRankType {

    public static void main(String args[]){

        String sentence = "yuaegulnmawnydkwlgceqaeqpmblgtlejrdknyeuqxhckxtpkwbubvctiemdrneowcuehqeimwcwflulvg 595339099.147695795 630896771 lwwsxubvthynidcccrkmalnowivedhcforrznxstjwkncxhmflcscmwuiaoyofxmcemqogkonfyrbcmtaqzwbxs 236182218.808632057 tbh utfekkvhtqhzhvhgquevdqdaygpkpbjsoeekcvlwjupovrkqoeoxfhozx ofvev nrqitrvuvlergcqwmoraslcxhrxyjxzfqwesyesanoy 294185592.996202747 936378539.701509858 368972894 466758129.504899673 xwisozalekzgnzeuvrjrmntynqdcwqfdekwcyobvtolzlpdiqlgvwvjztiancij tlp 598182337.993968457 200695826 240742277 lwnljdvvpqtnjbvgroxekirittcryghfecmgglstslndwumuxxnzjwrjcbcwihetbnozduwa 85023692 568907214 270726456 462250693 81802826.21487938 ysbcgnwdbxztiumplyfsnrjksfdvuubumdwkwbxzdwahwemengg orhxzmhzlukrzfribbouranoiqywmucxunwhdqoqslpylstxzpoarqpkgvzpgfepmvrofqlcqlyahbrknien 391589452.827936081 102274761 261401186 653932434.733387241 odtzbigibuvoeylixnonoxwjhjfmyfcvopnpc 648448142.524797055 22717067 753429832.564108771 152047842.288423206 942349312.646235415 593322363.416951209 607088507 655581717.841308296 ";

        String[] words = sentence.split(" ");

        int stringCount = 0;
        int doubleCount = 0;
        int intCount = 0;

        for(String word : words){
            if(word.matches("\\d+")){
                intCount++;
            }else if(word.matches("\\d*[.]\\d+")){
                doubleCount++;
            }else{
                stringCount++;
            }
        }

        System.out.println("string " + stringCount);
        System.out.println("integer " + intCount);
        System.out.println("double " + doubleCount);
    }
}
