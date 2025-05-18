
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void bfs(int start, vector<vector<int>>& graph, vector<bool>& visited)
{
    queue<int> q;
    visited[start] = true;
    q.push(start);

    cout << "BFS Traversal: ";

    while (!q.empty())
    {
        int current = q.front();
        q.pop();
        cout << current << " ";

        for (int neighbor : graph[current])
        {
            if (!visited[neighbor])
            {
                visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }

    cout << endl;
}

int main()
{
    int nodes, edges;
    cout << "Enter number of nodes and edges: ";
    cin >> nodes >> edges;

    vector<vector<int>> graph(nodes + 1);
    vector<bool> visited(nodes + 1, false);

    cout << "Enter edges (u v):" << endl;
    for (int i = 0; i < edges; ++i)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    int startNode;
    cout << "Enter starting node: ";
    cin >> startNode;

    bfs(startNode, graph, visited);

    return 0;
}
