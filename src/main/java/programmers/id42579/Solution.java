package programmers.id42579;

import java.util.*;

public class Solution {

    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        Map<String, Genre> genreMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Song song = new Song(i, genres[i], plays[i]);
            if (!genreMap.containsKey(song.genre)) {
                // 해당 장르가 없을 때
                Genre genre = new Genre(song.genre);
                genre.add(song);
                genreMap.put(song.genre, genre);
                continue;
            }

            // 해당 장르가 있을 때
            genreMap.get(song.genre).add(song);
        }

        List<Genre> genreList = new ArrayList<>(genreMap.values());
        Collections.sort(genreList, new Comparator<Genre>() {
            @Override
            public int compare(Genre o1, Genre o2) {
                return o2.playCnt - o1.playCnt;
            }
        });

        List<Integer> idxList = new ArrayList<>();
        for (Genre genre : genreList) {
            idxList.add(genre.songs[0].idx);

            if (genre.songs[1] == null) {
                continue;
            }

            idxList.add(genre.songs[1].idx);
        }

        int [] answer = new int[idxList.size()];
        for (int i = 0; i < idxList.size(); i++) {
            answer[i] = idxList.get(i);
        }
        return answer;
    }

    class Genre {
        String name;
        int playCnt;

        private Song[] songs;

        Genre(String name) {
            this.name = name;
            this.playCnt = 0;
            this.songs = new Song[2];
        }

        void add(Song addedSong) {
            addPlayCnt(addedSong);

            for (int i = 0; i < songs.length; i++) {
                if (songs[i] == null) {
                    songs[i] = addedSong;
                    return;
                }

                if (addedSong.playCnt > songs[i].playCnt ||
                        (addedSong.playCnt == songs[i].playCnt && addedSong.idx < songs[i].idx)) {
                    Song temp = songs[i];
                    songs[i] = addedSong;

                    if (i == 0) {
                        songs[i + 1] = temp;
                    }
                    return;
                }
            }
        }

        private void addPlayCnt(Song song) {
            playCnt += song.playCnt;
        }
    }

    class Song {
        int idx;
        String genre;
        int playCnt;

        Song(int idx, String genre, int playCnt) {
            this.idx = idx;
            this.genre = genre;
            this.playCnt = playCnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for (int element : answer) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}