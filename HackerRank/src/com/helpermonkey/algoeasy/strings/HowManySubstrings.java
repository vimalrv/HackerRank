package com.helpermonkey.algoeasy.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

//public class HowManySubstrings {
//
//	public static String createSubString(char[] baseCharArr, int startIndex, int noOfChars) {
//		StringBuilder sb = new StringBuilder();
//		int endIndex = startIndex + noOfChars;
//		for (int i = startIndex; i < endIndex; i++) {
//			sb.append(baseCharArr[i]);
//		}
//
//		return sb.toString();
//	}
//
//	public static int findUniqueSubStrings(String str) {
//		// ArrayList<Integer> uniqueSubStrings = new ArrayList<Integer>();
//
//		// char[] origCharArr = str.toCharArray();
//		char[] baseCharArr = str.toCharArray();
//		int baseCntr = 0;
//
//		// i+1 denotes the substring no of character like 1 char ss, 2 char ss, 3 char ss etc. until n-1 char ss, n char
//		// ss is basically the whole word anyway.
//		for (int i = 0; i < baseCharArr.length; i++) {
//			int noOfCharSS = i + 1;
//			for (int startIndex = 0; startIndex < baseCharArr.length; startIndex++) {
//				int newBaseCntr = 0;
//				// if the substring is going to be larger than the available portion of str, dont go further
//				if (((startIndex + noOfCharSS) > baseCharArr.length)) {
//					break;
//				}
//				String baseSubStr = createSubString(baseCharArr, startIndex, noOfCharSS);
//				newBaseCntr++;
//				int duplicateCntr = 0;
//
//				for (int j = (startIndex + 1); j < baseCharArr.length; j++) {
//					// if the substring is going to be larger than the available portion of str, dont go further
//					if (((j + noOfCharSS) > baseCharArr.length)) {
//						break;
//					}
//					String newSubStr = createSubString(baseCharArr, j, noOfCharSS);
//					if (baseSubStr.equals(newSubStr)) {
//						duplicateCntr++;
//					}
//				}
//				if (duplicateCntr < newBaseCntr) {
//					baseCntr = baseCntr + (newBaseCntr - duplicateCntr);
//				}
//
//			}
//		}
//
//		return baseCntr;
//	}
//
//	public static boolean validateAlternatingSequence(char[] newSeq, int length) {
//		for (int i = 0; i < length - 1; i++) {
//			if (newSeq[i] == newSeq[i + 1]) {
//				return false;
//			}
//		}
//
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//
//		int n = in.nextInt();
//		int q = in.nextInt();
//		String s = in.next();
//
//		for (int a0 = 0; a0 < q; a0++) {
//			int left = in.nextInt();
//			int right = in.nextInt();
//
//			// we want to make the substring as inclusive one for the right as well.
//			String subString = s.substring(left, (right + 1));
//			System.out.println(findUniqueSubStrings(subString));
//		}
//
//		in.close();
//	}
//}
	
	

	public class HowManySubstrings {
	    public static void main(String[] args) {
	        InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        FastScanner in = new FastScanner(inputStream);
	        FastPrinter out = new FastPrinter(outputStream);
	        NumberOfSubstrings2 solver = new NumberOfSubstrings2();
	        solver.solve(1, in, out);
	        out.close();
	    }

	    static class NumberOfSubstrings2 {
	        public void solve(int testNumber, FastScanner in, FastPrinter out) {
	            int n = in.nextInt();
	            int q = in.nextInt();
	            String s = in.next();
	            int[] a = new int[s.length() + 1];
	            for (int i = 0; i < s.length(); i++) a[i] = s.charAt(i);
	            int[] sa = SuffixArray.buildSuffixArray(a);
	            int[] lcp = SuffixArray.getLCP(sa, a);
	            NumberOfSubstrings2.Query[] qs = new NumberOfSubstrings2.Query[q];
	            for (int i = 0; i < q; i++) {
	                qs[i] = new NumberOfSubstrings2.Query(in.nextInt() - 1, in.nextInt() - 1);
	            }
	            List<NumberOfSubstrings2.Query>[] queries = new List[n];
	            for (int i = 0; i < n; i++) queries[i] = new ArrayList<>();
	            for (NumberOfSubstrings2.Query e : qs) queries[e.left].add(e);
	            MinSegmentTree minTree = new MinSegmentTree(n + 1);
	            int[] where = new int[sa.length];
	            for (int i = 0; i < sa.length; i++) where[sa[i]] = i;
	            SparseTableMin stable = new SparseTableMin(lcp);
	            FenwickMultiSum fSum = new FenwickMultiSum(n);
	            for (int i = n - 1; i >= 0; i--) {
	                int suffix = where[i];
	                int curLen = 0;
	                while (true) {
	                    int left = -1;
	                    int right = suffix;
	                    while (left < right - 1) {
	                        int mid = (left + right) >> 1;
	                        if (stable.getMin(mid, suffix) <= curLen) {
	                            left = mid;
	                        } else {
	                            right = mid;
	                        }
	                    }
	                    int first = right;
	                    left = suffix - 1;
	                    right = n + 1;
	                    while (left < right - 1) {
	                        int mid = (left + right) >> 1;
	                        if (stable.getMin(suffix, mid + 1) <= curLen) {
	                            right = mid;
	                        } else {
	                            left = mid;
	                        }
	                    }
	                    int last = right;
	                    int j = minTree.getMin(first, last + 1);
	                    if (j == Integer.MAX_VALUE) break;
	                    int nextSuffix = where[j];
	                    int curLCP = nextSuffix < suffix ? stable.getMin(nextSuffix, suffix) : stable.getMin(suffix, nextSuffix);
	                    fSum.add(j + curLen, j + curLCP, -1);
	                    curLen = curLCP;
	                }
	                minTree.set(suffix, i);
	                fSum.add(i, n, 1);
	                for (NumberOfSubstrings2.Query e : queries[i]) {
	                    e.answer = fSum.getSum(e.left, e.right + 1);
	                }
	            }
	            for (NumberOfSubstrings2.Query e : qs) out.println(e.answer);
	        }

	        static class Query {
	            int left;
	            int right;
	            long answer;

	            public Query(int left, int right) {
	                this.left = left;
	                this.right = right;
	            }

	        }

	    }

	    static class FenwickMultiSum {
	        FenwickLong fX;
	        FenwickLong f;

	        public FenwickMultiSum(int n) {
	            fX = new FenwickLong(n);
	            f = new FenwickLong(n);
	        }

	        public void add(int x, long d) {
	            fX.add(x, d);
	            f.add(x, d * (1 - x));
	        }

	        public void add(int left, int right, long d) {
	            add(left, d);
	            add(right, -d);
	        }

	        public long getSum(int x) {
	            return f.getSum(x) + fX.getSum(x) * x;
	        }

	        public long getSum(int left, int right) {
	            return getSum(right - 1) - getSum(left - 1);
	        }

	    }

	    static class MinSegmentTree {
	        int[] min;
	        int[] minId;
	        int n;

	        public MinSegmentTree(int n) {
	            this.n = Integer.highestOneBit(n) << 1;
	            min = new int[this.n * 2];
	            minId = new int[this.n * 2];
	            for (int i = 0; i < n; i++) {
	                minId[i + this.n] = i;
	            }
	            for (int i = 0; i < n; i++) {
	                set(i, Integer.MAX_VALUE);
	            }
	        }

	        public void set(int x, int y) {
	            x += n;
	            min[x] = y;
	            while (x > 1) {
	                x >>= 1;
	                int left = min[x << 1];
	                int right = min[(x << 1) | 1];
	                if (left <= right) {
	                    min[x] = left;
	                    minId[x] = minId[x << 1];
	                } else {
	                    min[x] = right;
	                    minId[x] = minId[(x << 1) | 1];
	                }
	            }
	        }

	        public int getMin(int left, int right) {
	            --right;
	            left += n;
	            right += n;
	            int ret = Integer.MAX_VALUE;
	            while (left <= right) {
	                if ((left & 1) == 1) {
	                    ret = Math.min(ret, min[left]);
	                    left++;
	                }
	                if ((right & 1) == 0) {
	                    ret = Math.min(ret, min[right]);
	                    right--;
	                }
	                left >>= 1;
	                right >>= 1;
	            }
	            return ret;
	        }

	    }

	    static class FenwickLong {
	        long[] a;

	        public FenwickLong(int n) {
	            a = new long[n];
	        }

	        public void add(int x, long y) {
	            for (int i = x; i < a.length; i |= i + 1) {
	                a[i] += y;
	            }
	        }

	        public long getSum(int x) {
	            if (x >= a.length) x = a.length - 1;
	            long ret = 0;
	            for (int i = x; i >= 0; i = (i & (i + 1)) - 1) {
	                ret += a[i];
	            }
	            return ret;
	        }

	    }

	    static class FastScanner extends BufferedReader {
	        public FastScanner(InputStream is) {
	            super(new InputStreamReader(is));
	        }


	        public int read() {
	            try {
	                int ret = super.read();
//	            if (isEOF && ret < 0) {
//	                throw new InputMismatchException();
//	            }
//	            isEOF = ret == -1;
	                return ret;
	            } catch (IOException e) {
	                throw new InputMismatchException();
	            }
	        }

	        public String next() {
	            StringBuilder sb = new StringBuilder();
	            int c = read();
	            while (isWhiteSpace(c)) {
	                c = read();
	            }
	            if (c < 0) {
	                return null;
	            }
	            while (c >= 0 && !isWhiteSpace(c)) {
	                sb.appendCodePoint(c);
	                c = read();
	            }
	            return sb.toString();
	        }

	        static boolean isWhiteSpace(int c) {
	            return c >= 0 && c <= 32;
	        }

	        public int nextInt() {
	            int c = read();
	            while (isWhiteSpace(c)) {
	                c = read();
	            }
	            int sgn = 1;
	            if (c == '-') {
	                sgn = -1;
	                c = read();
	            }
	            int ret = 0;
	            while (c >= 0 && !isWhiteSpace(c)) {
	                if (c < '0' || c > '9') {
	                    throw new NumberFormatException("digit expected " + (char) c
	                            + " found");
	                }
	                ret = ret * 10 + c - '0';
	                c = read();
	            }
	            return ret * sgn;
	        }

	        public String readLine() {
	            try {
	                return super.readLine();
	            } catch (IOException e) {
	                return null;
	            }
	        }

	    }

	    static class FastPrinter extends PrintWriter {
	        public FastPrinter(OutputStream out) {
	            super(out);
	        }

	        public FastPrinter(Writer out) {
	            super(out);
	        }

	    }

	    static class SparseTableMin {
	        int[][] min;
	        int[] h;

	        public SparseTableMin(int[] a) {
	            h = new int[a.length + 1];
	            h[1] = 0;
	            for (int i = 2; i < h.length; i++) {
	                h[i] = h[i >> 1] + 1;
	            }
	            min = new int[h[h.length - 1] + 1][a.length];
	            for (int i = 0; i < a.length; i++) {
	                min[0][i] = a[i];
	            }
	            for (int i = 1; i < min.length; i++) {
	                int[] prev = min[i - 1];
	                int[] mini = min[i];
	                for (int v = 0; v < a.length; v++) {
	                    if (v + (1 << (i - 1)) < a.length) {
	                        mini[v] = Math.min(prev[v], prev[v + (1 << (i - 1))]);
	                    } else {
	                        mini[v] = prev[v];
	                    }
	                }
	            }
	        }

	        public int getMin(int left, int right) {
	            if (right <= left) {
	                return Integer.MAX_VALUE;
	            }
	            int k = h[right - left];
	            int[] mink = min[k];
	            return Math.min(mink[left], mink[right - (1 << k)]);
	        }

	    }

	    static class SuffixArray {
	        public static int[] buildSuffixArray(int[] s) {
	            int n = s.length;
	            int alphabet = 0;
	            for (int i : s) {
	                alphabet = Math.max(alphabet, i);
	            }
	            ++alphabet;
	            int[] h = new int[Math.max(n, alphabet)];
	            int[] c = new int[n];
	            int[] d = new int[n];
	            int[] count = new int[alphabet];
	            for (int i = 0; i < n; i++) {
	                c[i] = s[i];
	                count[c[i]]++;
	            }
	            for (int i = 1; i < alphabet; i++) {
	                h[i] = h[i - 1] + count[i - 1];
	            }
	            int[] a = new int[n];
	            int[] b = new int[n];
	            {
	                int[] g = h.clone();
	                for (int i = 0; i < n; i++) {
	                    a[g[c[i]]++] = i;
	                }
	            }
	            for (int w = 1; w < n; w <<= 1) {
	                for (int i = 0; i < n; i++) {
	                    int j = good(a[i] - w + n, n);
	                    b[h[c[j]]++] = j;
	                }
	                int nc = 0;
	                h[nc++] = 0;
	                d[b[0]] = 0;
	                for (int i = 1; i < n; i++) {
	                    if (c[b[i]] != c[b[i - 1]] || c[good(b[i] + w, n)] != c[good(b[i - 1] + w, n)]) {
	                        h[nc++] = i;
	                    }
	                    d[b[i]] = nc - 1;
	                }
	                int[] t = a;
	                a = b;
	                b = t;
	                t = c;
	                c = d;
	                d = t;
	            }
	            return a;
	        }

	        static int good(int x, int n) {
	            if (x >= n) {
	                x -= n;
	            }
	            return x;
	        }

	        public static int[] getLCP(int[] sa, int[] a) {
	            int k = 0;
	            int n = a.length;
	            int[] rev = new int[n];
	            for (int i = 0; i < n; i++) {
	                rev[sa[i]] = i;
	            }
	            int[] lcp = new int[n];
	            for (int i = 0; i < n; i++) {
	                k = Math.max(k - 1, 0);
	                int j = rev[i] + 1;
	                if (j >= n) continue;
	                j = sa[j];
	                while (i + k < n && j + k < n && a[i + k] == a[j + k]) ++k;
	                lcp[rev[i]] = k;
	            }
	            return lcp;
	        }

	    }
	}