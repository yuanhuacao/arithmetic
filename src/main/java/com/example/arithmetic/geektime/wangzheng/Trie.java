package com.example.arithmetic.geektime.wangzheng;

/**
 * @Description: TODO
 * @Author: 曹远华 (yuanhua.cao@luckincoffee.com)
 * @Date: 2018/12/25 16:30
 */

public class Trie {
	/**
	 * 存储无意义字符
	 */
	private TrieNode root = new TrieNode('/');

	/**
	 * 	往 Trie 树中插入一个字符串
	 */
	public void insert(char[] text) {
		TrieNode p = root;
		for (int i = 0; i < text.length; ++i) {
			int index = text[i] - 'a';
			if (p.children[index] == null) {
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}

	/**
	 * 在 Trie 树中查找一个字符串
	 * @param pattern
	 * @return
	 */
	public boolean find(char[] pattern) {
		TrieNode p = root;
		for (int i = 0; i < pattern.length; ++i) {
			int index = pattern[i] - 'a';
			if (p.children[index] == null) {
				// 不存在 pattern
				return false;
			}
			p = p.children[index];
		}
		if (p.isEndingChar == false) {
			// 不能完全匹配，只是前缀
			return false;
		}else {
			// 找到 pattern
			return true;
		}
	}

	public class TrieNode {

		public char data;
		public TrieNode[] children = new TrieNode[26];
		public boolean isEndingChar = false;

		public TrieNode(char data) {
			this.data = data;
		}
	}

}
