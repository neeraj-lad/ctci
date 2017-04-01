/*
 *You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project'sdependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 *EXAMPLE Input:
 *projects: a, b, c, d, e, f
 *dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c
 *
 *i/p:
 *String projects, String dependencies
 *
 *o/p:
 *String buildOrder
 *
 */

import java.io.*;
import java.util.*;

class Graph {
	String[] nodes;
	Map<String, List<String>> adjList;

	Graph(String p, String d) {
		nodes = p.split(" ");
		adjList = new HashMap<String, List<String>>();
		for (String n : nodes)	adjList.put(n, new ArrayList<String>());
		String[] dep = d.split(" ");
		for (int i = 0; i < dep.length; i += 2) {
			adjList.get(dep[i]).add(dep[i + 1]);	
		}	
	}

	String getBuildOrder() {
		return ("Using Kahn's algorithm: " + kahn() + "\nUsing DFS: " + dfs());
	}

	String kahn() {
		Map<String, Integer> indegree = new HashMap<String, Integer>();
		for (String n : nodes)	indegree.put(n, 0);
		for (String n : nodes) {
			for (String out : adjList.get(n)) {
				indegree.put(out, indegree.get(out) + 1);	
			}	
		}
		
		Queue<String> indegreeZero = new LinkedList<String>();
		for (String n : nodes) {
			if (indegree.get(n) == 0)	indegreeZero.add(n);	
		}
		
		Queue<String> buildOrder = new LinkedList<String>();
		int cnt = 0;
		while (!indegreeZero.isEmpty()) {
			String n = indegreeZero.remove();
			buildOrder.add(n);
			cnt++;
			for (String out : adjList.get(n)) {
				indegree.put(out, indegree.get(out) - 1);
				if (indegree.get(out) == 0)	indegreeZero.add(out);	
			}	
		}
		if (cnt != nodes.length)	return "ERROR: Input is not a Directed Acyclic Graph";
		String res = new String();
		while (!buildOrder.isEmpty())	res += buildOrder.remove() + " ";
		return res;
	}	

	String dfs() {
		Map<String, String> status = new HashMap<String, String>();
		for (String n : nodes)	status.put(n, "unvisited");

		Deque<String> stack = new ArrayDeque<String>();
		for (String n : nodes) {
			if (status.get(n).equals("unvisited")) {
				if (!(dfsHelper(n, status, stack)))	return "ERROR: Input is not a Directed Acyclic Graph";	
			}	
		}

		String res = new String();
		while (!stack.isEmpty())	res += stack.removeFirst() + " ";
		return res;	
	}

	boolean dfsHelper(String n, Map<String, String> status, Deque<String> stack) {
		if (status.get(n).equals("processing"))	return false;	

		if (status.get(n).equals("unvisited")) {
			status.put(n, "processing");
			for (String out : adjList.get(n)) {
				if (!status.get(out).equals("visited")) {
					if(!dfsHelper(out, status, stack))	return false;
				}	
			}
			stack.addFirst(n);
			status.put(n, "visited");
		}
		return true;	
	}
}

class BuildOrder {
    public static void main(String args[]) {
		String projects = "a b c d e f";
		String dependencies = "a d f b b d f a d c a f";
		
		Graph g = new Graph(projects, dependencies);
		System.out.println(g.getBuildOrder());
    }
}

