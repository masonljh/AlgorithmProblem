### 문제 4.3 깊이의 리스트
- 이진트리가 주어졌을 때, 같은 깊이에 있는 노드를 연결리스트로 연결해 주는 알고리즘을 설계하라. 즉, 트리의 깊이가 D라면 D개의 연결리스트를 만들어야한다.

### 문제 풀이
- 하위 노드를 계속 탐색
- 만약 해당 노드가 찾는 깊이라면 그 노드를 리턴
- 위 조건이 아니라면 계속 하위 노드를 탐색 