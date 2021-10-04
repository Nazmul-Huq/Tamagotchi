import java.util.HashMap;
import java.util.Map;

public class Images {

    // rules to set images (k1 to k5 default for all animals)
    // k1 = Animal's cute image (common image to show when not doing any activity)
    // k2 = playing
    // K3 = eating,
    // K4 = cleaning,
    // K5= sleeping,
    // k6 to rest, see specific variable


    // images for Dog
    // K6 = running
    static HashMap<Integer, String > dogImages = new HashMap<>(Map.of(
            1,"            __\n" +
                    "(\\,--------'()'--o\n" +
                    " (_    ___    /~\"\n" +
                    "  (_)_)  (_)_)",

            2,"   ___\n" +
                    " __/_  `.  .-\"\"\"-.\n" +
                    " \\_,` | \\-'  /   )`-')\n" +
                    "  \"\") `\"`    \\  ((`\"`\n" +
                    " ___Y  ,    .'7 /|\n" +
                    "(_,___/...-` (_/_/ sk",

            3,"              _,)\n" +
                    "        _..._.-;-'\n" +
                    "     .-'     `(\n" +
                    "    /      ;   \\\n" +
                    "   ;.' ;`  ,;  ;\n" +
                    "  .'' ``. (  \\ ;\n" +
                    " / f_ _L \\ ;  )\\\n" +
                    " \\/|` '|\\/;; <;/\n" +
                    "((; \\_/  (()       Felix Lee\n" +
                    "     \"",

            4,"  ''',\n" +
                    "o_)O \\)____)\"\n" +
                    " \\_        )\n" +
                    "   '',,,,,,\n" +
                    "     ||  ||\n" +
                    "    \"--'\"--'",

            5,"               _\n" +
                    "            ,/A\\,\n" +
                    "          .//`_`\\\\,\n" +
                    "        ,//`____-`\\\\,\n" +
                    "      ,//`[_Sleep_]`\\\\,\n" +
                    "    ,//`=  ==  __-  _`\\\\,\n" +
                    "   //|__=  __- == _  __|\\\\\n" +
                    "   ` |  __ .-----.  _  | `\n" +
                    "     | - _/       \\-   |\n" +
                    "     |__  | .-\"-. | __=|\n" +
                    "     |  _=|/)   (\\|    |\n" +
                    "     |-__ (/ zzz \\) -__|\n" +
                    "     |___ /`\\_Y_/`\\____|\n" +
                    "          \\)8===8(/",

            6,"Running Dog"+
                    ".--~~,__\n" +
                    "   :-....,-------`~~'._.'\n" +
                    "    `-,,,  ,_      ;'~U'\n" +
                    "     _,-' ,'`-__; '--.\n" +
                    "    (_/'~~      ''''(;"

    ));


    // images for Cat
    // K6 =
    static HashMap<Integer, String > catImages = new HashMap<>(Map.of(
            1,"(\"`-''-/\").___..--''\"`-._ \n" +
                    " `6_ 6  )   `-.  (     ).`-.__.`) \n" +
                    " (_Y_.)'  ._   )  `._ `. ``-..-' \n" +
                    "   _..`--'_..-_/  /--'_.'\n" +
                    "  ((((.-''  ((((.'  (((.-' ",

            2,"                      (`.-,')\n" +
                    "                    .-'     ;\n" +
                    "                _.-'   , `,-\n" +
                    "          _ _.-'     .'  /._\n" +
                    "        .' `  _.-.  /  ,'._;)\n" +
                    "       (       .  )-| (\n" +
                    "        )`,_ ,'_,'  \\_;)\n" +
                    "('_  _,'.'  (___,))\n" +
                    " `-:;.-'",

            3," ,-.       _,---._ __  / \\\n" +
                    " /  )    .-'       `./ /   \\\n" +
                    "(  (   ,'            `/    /|\n" +
                    " \\  `-\"             \\'\\   / |\n" +
                    "  `.              ,  \\ \\ /  |\n" +
                    "   /`.          ,'-`----Y   |\n" +
                    "  (            ;        |   '\n" +
                    "  |  ,-.    ,-'         |  /\n" +
                    "  |  | (   |        hjw | /\n" +
                    "  )  |  \\  `.___________|/\n" +
                    "  `--'   `--'",

            4,"    |\\__/,|   (`\\\n" +
                    "  _.|o o  |_   ) )\n" +
                    "-(((---(((--------",

            5,"\n" +
                    "              __..--''``---....___   _..._    __\n" +
                    "    /// //_.-'    .-/\";  `        ``<._  ``.''_ `. / // /\n" +
                    "   ///_.-' _..--.'_    \\                    `( ) ) // //\n" +
                    "   / (_..-' // (< _     ;_..__               ; `' / ///\n" +
                    "    / // // //  `-._,_)' // / ``--...____..-' /// / //",

            6,"playing outside with other kitten\n" +
                    "                      /^--^\\     /^--^\\     /^--^\\\n" +
                    "                      \\____/     \\____/     \\____/\n" +
                    "                     /      \\   /      \\   /      \\\n" +
                    "KAT                 |        | |        | |        |\n" +
                    "                     \\__  __/   \\__  __/   \\__  __/\n" +
                    "|^|^|^|^|^|^|^|^|^|^|^|^\\ \\^|^|^|^/ /^|^|^|^|^\\ \\^|^|^|^|^|^|^|^|^|^|^|^|\n" +
                    "| | | | | | | | | | | | |\\ \\| | |/ /| | | | | | \\ \\ | | | | | | | | | | |\n" +
                    "########################/ /######\\ \\###########/ /#######################\n" +
                    "| | | | | | | | | | | | \\/| | | | \\/| | | | | |\\/ | | | | | | | | | | | |\n" +
                    "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|"
    ));


    //images for horse
    // horse riding
    static HashMap<Integer, String > horseImages = new HashMap<>(Map.of(
            1, "                          _(\\_/) \n" +
                    "                          ,((((^`\\\n" +
                    "                         ((((  (6 \\ \n" +
                    "                       ,((((( ,    \\\n" +
                    "   ,,,_              ,(((((  /\"._  ,`,\n" +
                    "  ((((\\\\ ,...       ,((((   /    `-.-'\n" +
                    "  )))  ;'    `\"'\"'\"\"((((   (      \n" +
                    " (((  /            (((      \\\n" +
                    "  )) |                      |\n" +
                    " ((  |        .       '     |\n" +
                    " ))  \\     _ '      `t   ,.')\n" +
                    " (   |   y;- -,-\"\"'\"-.\\   \\/  \n" +
                    " )   / ./  ) /         `\\  \\\n" +
                    "    |./   ( (           / /'\n" +
                    "    ||     \\\\          //'|\n" +
                    "jgs ||      \\\\       _//'||\n" +
                    "    ||       ))     |_/  ||\n" +
                    "    \\_\\     |_/          ||\n" +
                    "    `'\"                  \\_\\",

            2, " ~,  O\n" +
                    " /)\\~_/\\\n" +
                    "'  \\ \\~_\\__ ~\n" +
                    "  _|_)_\\_( )~~~\n" +
                    "//   /|   \\|\\\n" +
                    "  ()//|     \\`\n" +
                    "  ||/||\n" +
                    "  ||\n" +
                    "  || ejm98",

            3, "     _ ____\n" +
                    "     /( ) _   \\\n" +
                    "    / //   /\\` \\,  ||--||--||-\n" +
                    "      \\|   |/  \\|  ||--||--||-\n" +
                    "~^~^~^~~^~~~^~~^^~^^^^^^^^^^^^",

            4, "           ,--,\n" +
                    "     _ ___/ /\\|\n" +
                    " ,;'( )__, )  ~\n" +
                    "//  //   '--; \n" +
                    "'   \\     | ^\n" +
                    "     ^    ^",

            5, "         /           /   \n" +
                    "         /' .,,,,  ./       \n" +
                    "        /';'     ,/        \n" +
                    "       / /   ,,//,`'`     \n" +
                    "      ( ,, '_,  ,,,' ``   \n" +
                    "      |    /@  ,,, ;\" `   \n" +
                    "     /    .   ,''/' `,``   \n" +
                    "    /   .     ./, `,, ` ; \n" +
                    " ,./  .   ,-,',` ,,/''\\,' \n" +
                    "|   /; ./,,'`,,'' |   |   \n" +
                    "|     /   ','    /    |   \n" +
                    " \\___/'   '     |     |  \n" +
                    "  `,,'   |      /     `\\  \n" +
                    "        /      |        ~\\  \n" +
                    "       '       (          \n" +
                    "      :                    \n" +
                    "     ; .         \\         \n" +
                    "    :   \\         ;       Horse? \n" +
                    "       .                  by Ooyamaneko",

            6, "         {)          \n" +
                    "        c==//\\         \n" +
                    "   _-~~/-._|_|         \n" +
                    "  /'_,/,   //'~~~\\;;,  \n" +
                    "  `~  _( _||_..\\ | ';; \n" +
                    "    /'~|/ ~' `\\<\\>  ;  \n" +
                    "    \"  |      /  |     \n" +
                    "       \"      \"  \"    "

    ));

    public static void getImage(String usersChoiceOfAnimal, int activityForTamagotchi){
        if (usersChoiceOfAnimal.equals("dog")) {
            System.out.println(dogImages.get(activityForTamagotchi));
        } else if (usersChoiceOfAnimal.equals("cat")) {
            System.out.println(catImages.get(activityForTamagotchi));
        } else if (usersChoiceOfAnimal.equals("horse")) {
            System.out.println(horseImages.get(activityForTamagotchi));
        }
    }



}
