public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!"".equals(words[i])) {
                output.append(words[i]).append(" ");
            }
        }
        String outputString = output.toString();
        int length = outputString.length();
        if (length > 0 && outputString.charAt(length - 1) == ' ') {
            outputString = outputString.substring(0, length - 1);
        }
        return outputString;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        // String input = "the sky is blue";
        // String input = "  hello world!  ";
        String input = "a good   example";
        System.out.println(reverseWords.reverseWords(input));
    }
}
