### 트리
![](https://velog.velcdn.com/images/xeropise1/post/34e5b81f-7e11-467d-9915-eb12c7a48b37/image.png)



- 비선형 (Non-Linear) 자료 구조 (하나의 자료 뒤에 여러개의 자료가 존재할 수 있는 것)
- 비선형 자료 구조는 대표적으로 트리와 그래프가 있음

- 각각의 노드(객체) 가 선으로 연결된 형태 (간선)

- 트리는 하나의 루트 노드가 존재하는 반면, 그래프는 루트라는 개념이 없다.

- 간선 수의 경우 노드가 N개라면 간선 수는 N-1


### 이진 트리

- 각 노드가 자식 노드를 최대 2개씩 보유 한 형태


**완전 이진 트리**

![](https://velog.velcdn.com/images/xeropise1/post/dace9f4c-5b27-4810-ac2c-41fd6376b1dc/image.png)

- 루프 부터 시작하여 왼쪽, 오른쪽 으로 모든 노드가 차 있는 경우
- 왼쪽 부터 노드가 차 있어야 한다.
- 꼭 모든 레벨이 차 있을 필요는 없다. 좌부터 우로 만족만 하면됨

<br>

  ![](https://velog.velcdn.com/images/xeropise1/post/f042b41a-09ed-40f3-903c-81e8210513c5/image.png)

- 이 경우는 만족하지 않는다.

<br>

**포화 이진 트리**

<br>

![](https://velog.velcdn.com/images/xeropise1/post/06935c97-c1c9-4c1a-a0ee-12da019cc095/image.png)

- 모든 레벨에 노드가 꽉 차 있는 경우를 말한다.



[이 트리의 개념을 사용하여 인덱스에서 B-Tree 라는 개념을 사용하는데 알아 두면 좋다.](https://fomaios.tistory.com/entry/Data-Structure-B-Tree%EB%9E%80)


