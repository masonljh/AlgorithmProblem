### 문제
- https://programmers.co.kr/learn/courses/30/lessons/12981?language=java

### 풀이
- 이해
>- 끝말 잇기를 할 때 걸린 사람의 인덱스와 걸린 턴의 수를 구하는 문제임
- 풀이
>- 걸렸을 때의 index만 알 수 있다면 걸린 유저의 인덱스와 턴을 구할 수 있음
>- HashSet으로 한 이유는 순서는 상관없이 그 값이 있는지만 확인하면 되기 때문
>- 걸리는 조건은 HashSet에 그 값이 들어있거나 마지막 단어의 끝으로 시작하는 경우로 정함