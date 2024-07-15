package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(
                new String[]{"qgdwllrcxfrsqwgsoljgocbmtdffpbybqyytyqadvnmnykhixjpnthdgedqorgmdvicktajyjdmzseuihyjrbywmgqkxfooquqrjfzzrhtvohbylnnnzykkxelixdnpsurcavrlmipjwzpmkmodrljzneupdbcfdqyowjsdyprwyuvwotxlmksdjjcqesmwrartynkensakbvogaucgttjinfljwpoixwydhyffsmxrffqfpipwztdjxbrewsdzxgueqzrgmaggauznjtqdjeuxmomrrazjnmvgzbcvkfyoadnomuofhnzohmwdtqcgliwlhebfwofzljztpullvnfnpbfljaxjkismhtxosbqpbybogwwkjikddgyajiwbwkhbpjvtuiawigqfhsqnmagkxzxvbkyeatviadeklfmbdqrqkwigeobirpqurqsugdywcasidwnmsgwighaibnmyxmrpvadpqljewmvflclqpdgcwtbctsrivnbedpcyspcqafzuvzncgcnikwsongfyxaqejtmwvfzmieuxqseairkueblpexrlyevjvkp"} ,
                "ozljrxwqmfupseeyqbhydlszsbzfgddwcpgblwdopixujhndrhokizhixhaksnvvfwkmqkfdwbuotpeuwdjtojttxvwhpeiduuhxnwjczugjnztvotikukqinyufvlwazlafufwofoigiyimcqvoaxciyxspqzjimsnprqeslfjrefzlqzprydatyintskioezitnpwgfllnenngybvorkfholiifwvaerpmgygsvdfdxjddrrktvzepwyajdpjgdjybpzdxcrgkzovkopmvixiuquermwknalsdcrctuuqfwplilhhfsywzrkmorcyehstiargwwkqyodutucewxyqnadjvgtlbvfikmoaofaiugmooztmjtkiowixpfoydvnxhmxyyylaygiyhecmppusmpnbqhvscrxorzoxxykcrqooytkaognhrmlvlqzjaxmjrsscyomhkwxlzgwmciiquctzhzvtpevghpomdkfxiksvalixiqpwxolxzsdpitjkkrpfuyawaxrsdupmqxvxupltracnkqydmxkveffmxpmtshghyxehudlkakduqicultdsujoyqsijwcuuntafkpyeglfbxvkkisdcldpwjocaodstrazkfbojrsbfmqnogyhvetnzqslailatscfmnoywrbvtknymsolbuncqmjgtzktkzvfgafnwogcylsnegegbpaewcemyqexmrpcoeaqvceizhrcfgskxkymyeqrcyzzyovsvmqmfhnlvefwvpyubyytunpouahkiaudizdfwgcqpgxmytrgrhennpamhcwkrnywvwxyzbwaqkjxojbitlhigdqhkvhzvltafhasffzkjyvaqmseqbxdtgoyreldlrhahvtnsuvlrjmkhhzinenaujjareirepssiidrlxvbdolecsnjebikbyqezbxafyrwhbvtagwmnzcqjdbwdmokhuayyxebzovxtomlpxgqvzredctklc"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int shift = 97; // "a" letter (int)
        List<List<String>> result = new ArrayList<>();

        Node root = buildTrie(products, shift);

        Node node = root;
        boolean noMatch = false;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> tmp = new ArrayList<>();
            char c = searchWord.charAt(i);
            if (!noMatch && node.child[(int)c - shift] != null) {
                tmp = node.child[(int)c - shift].searchWords.stream().limit(3).collect(Collectors.toList());
                node = node.child[(int)c - shift];
            } else {
                noMatch = true;
            }
            result.add(tmp);

        }

        return result;
    }

    private Node buildTrie(String[] products, int shift) {
        Arrays.sort(products);

        Node root = new Node();

        for (int i = 0; i < products.length; i++) {
            String word = products[i];
            Node currentNode = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                currentNode.searchWords.add(word);
                if (currentNode.child[(int)c - shift] != null) {
                    currentNode = currentNode.child[(int)c - shift];
                } else {
                    Node newNode = new Node();
                    currentNode.child[(int)c - shift] = newNode;
                    currentNode = newNode;
                }
            }
            currentNode.searchWords.add(word);
        }
        return root;
    }
}


class Node {
    Node [] child = new Node [26];
    LinkedList<String> searchWords = new LinkedList<>();
}