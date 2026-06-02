# 593FinalProject

Group 13 Final Project — a Java implementation of the **Rope** data structure, a tree-based alternative to `String` designed for efficient editing of very large text (100 MB+).

## Background

A Rope stores text as the leaves of a binary tree. Each internal node carries a `weight` (the length of text in its left subtree), so concatenation, insertion, deletion, and substring extraction can be done by re-linking subtrees instead of copying entire strings. This makes a Rope much faster than a flat `String`/`StringBuilder` once the text is large enough that copying becomes the bottleneck.

## Goals

The project benchmarks Rope behaviour on the editing workloads that motivate the data structure:

- Load 100 MB+ of text
- Insert 1, 2, … 200 chars in the middle of a 100 MB rope
- Save the rope back out
- Delete 1, 2, … 200 chars in the middle
- Delete a range of 1k–20k chars
- Extract a screenful of text (a rectangular window) at the start, middle, and end

## Repository layout

| File | Role |
| --- | --- |
| `Rope.java` | Swing GUI entry point with `load` / `insert` / `save` / `delete` / `extract` buttons. |
| `RopeStructure.java` | Core implementation — the `Node` class plus tree operations: `append`, `insert`, `extract`, `delete`, `split`, `concatenation`, `search`, `printRope`, `length`. |
| `Test.java` | Driver that generates ~10 MB of test data, builds a `RopeStructure`, and exercises the operations. |
| `ropestructure.java` / `delete middle.java` | Earlier experiments kept for reference. |
| `RopeBuilder.java`, `RepeatedCharacterSequence.java` | Reference material from Amin Ahmad's `org.ahmadsoft.ropes` library (GPL). |
| `LinkedList.java` | Early linked-list scaffolding from before the tree implementation. |

## Core API (`RopeStructure`)

```java
RopeStructure rs = new RopeStructure(data);   // build from String[]
rs.append("more text");                       // append at the tail
rs.insert("xyz", 1024);                       // insert at index
rs.delete(256, 257);                          // delete a range
char c   = rs.search(rs.root, 12);            // index lookup
int  len = rs.length(rs.root);                // total length
rs.printRope(rs.root);                        // in-order print
```

## Build & run

The sources live at the repo root and use the `rope593` package. From this directory:

```bash
# compile
javac -d out Rope.java RopeStructure.java Test.java

# run the GUI
java -cp out rope593.Rope

# run the benchmark / smoke test
java -cp out rope593.Test
```

## Authors

Group 13 — Tianze Liang, Shaobo Li, Xu Nan.
