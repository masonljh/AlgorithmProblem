### 문제
- https://programmers.co.kr/learn/courses/30/lessons/12980?language=java

### 풀이
- 이해
>- 점프는 한 칸씩만 되며 이 때 배터리도 한 칸씩 소모함
>- 순간이동은 배터리가 소모되지 않지만 무조건 현재까지 온 거리의 2배만 이동할 수 있음
>- 순간이동 거리보다 가야하는 거리가 짧은 경우에는 무조건 뛸 수 밖에 없음
- 풀이
>- 2로 나눈 값에 대해서 나머지가 있으면 배터리 사용량으로 봄
>- 처음에 한 번은 무조건 움직여야하므로 answer는 1부터 시작