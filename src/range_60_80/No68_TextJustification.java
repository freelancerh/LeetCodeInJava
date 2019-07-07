package range_60_80;

import java.util.ArrayList;
import java.util.List;

public class No68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth < 1 || words == null || words.length == 0){
            return new ArrayList<>();
        }

        List<List<String>> lineStringList = new ArrayList<>();
        int currentSize = 0;
        List<String> currentStringList = null;
        for (String word : words){
            if (currentStringList == null){
                currentStringList = new ArrayList<>();
                lineStringList.add(currentStringList);
            }

            currentSize = currentStringList.size() == 0 ? currentSize + word.length() : currentSize + word.length() + 1;
            if (currentSize < maxWidth + 1){
                currentStringList.add(word);
            } else {
                currentStringList = new ArrayList<>();
                currentStringList.add(word);
                currentSize = word.length();
                lineStringList.add(currentStringList);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < lineStringList.size(); i++) {
            List<String> stringList = lineStringList.get(i);
            if (i == lineStringList.size() - 1){
                result.add(getLastString(stringList, maxWidth));
            } else {
                result.add(getLineString(stringList, maxWidth));
            }
        }

        return result;
    }

    private String getLastString(List<String> lineStringList, int maxWidth){
        int charSize = 0;
        for (String word : lineStringList){
            charSize += word.length();
        }

        int emptySize = 0;
        String result = "";
        for (int i = 0; i < lineStringList.size(); i++) {
            if (i == lineStringList.size() - 1){
                result = result.concat(lineStringList.get(i)).concat(getEmptyString(maxWidth - charSize - emptySize));
            } else {
                result = result.concat(lineStringList.get(i)).concat(" ");
                emptySize++;
            }
        }

        return result;
    }

    private String getLineString(List<String> lineStringList, int maxWidth){
        if (lineStringList.size() == 1){
            return lineStringList.get(0) + getEmptyString(maxWidth - lineStringList.get(0).length());
        }

        int wordCount = lineStringList.size();
        int charSize = 0;
        for (String word : lineStringList){
            charSize += word.length();
        }

        int emptySize = maxWidth - charSize;
        int emptyCount = wordCount - 1;
        int avgEmptySize = emptySize / emptyCount;
        int lastEmptySize = emptySize % emptyCount;
        String result = "";
        for (int i = 0; i < lineStringList.size(); i++){
            if (i == lineStringList.size() - 1){
                result = result.concat(lineStringList.get(i));
            } else {
                int emptyCharSize = ( lastEmptySize-- > 0 ? 1 : 0) + avgEmptySize;
                result = result.concat(lineStringList.get(i)).concat(getEmptyString(emptyCharSize));
            }
        }

        return result;
    }

    private String getEmptyString(int emptyCharSize){
        char[] arr = new char[emptyCharSize];
        for (int i = 0; i < emptyCharSize; i++) {
            arr[i] = ' ';
        }

        return new String(arr);
    }
}
