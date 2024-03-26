from collections import deque

def solution(n, wires):
    answer = n
    
    def bfs(start, wires):
        que = deque([start])
        visited[start] = True
        
        towerCount = 1
        
        while que:
            current = que.popleft()
            
            for wire in wires:
                # 주어지는 와이어는 index가 1부터 시작하므로 1을 빼준다
                if wire[0]-1 == current and visited[wire[1]-1] == False:
                    visited[wire[1]-1] = True
                    que.append(wire[1]-1)
                    towerCount += 1
                elif wire[1]-1 == current and visited[wire[0]-1] == False:
                    visited[wire[0]-1] = True
                    que.append(wire[0]-1)
                    towerCount += 1
            
        return towerCount
    
    # 모든 전력망을 순회
    for i in range(len(wires)):
        # 전선중 하나가 잘린 상태의 전력망
        cuttedWires = [value for index, value in enumerate(wires) if index != i]
        cuttedWire = wires[i]
        
        # 전력망을 bfs로 순회하기 위한 방문 목록
        visited = [False for _ in range(n)]
        
        # 자른 전선을 기준으로 한쪽을 순회하여 노드수를 구하고 송전탑 개수의 차이를 저장
        result = abs(n - 2 * bfs(cuttedWire[0]-1,cuttedWires))
        
        # 송전탑 개수를 최대한 비슷하게 맞춤
        if result < answer:
            answer = result

    return answer
