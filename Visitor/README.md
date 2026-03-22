# Visitor File System Assignment

This project implements a file system model using the Visitor design pattern.

## Included Components

- `FileSystemElement`: base interface for file system elements.
- `File`: leaf element with `name` and `sizeInMb`.
- `Directory`: composite element that stores files/subdirectories.
- `FileSystemVisitor`: visitor contract for files and directories.
- `SizeCalculatorVisitor`: accumulates total file size.
- `SearchVisitor`: accumulates files matching a given criterion.
- `Main`: creates a sample structure and runs both visitors.

## Example Usage

The sample in `src/main/java/org/example/Main.java` creates this structure:

- `root/`
  - `notes.txt` (1.2 MB)
  - `docs/`
	- `report.pdf` (2.8 MB)
	- `todo.txt` (0.5 MB)
  - `images/`
	- `diagram.png` (3.4 MB)

Then it applies:

- `SizeCalculatorVisitor` to compute total file size.
- `SearchVisitor` with criterion `name.endsWith(".txt")` to collect matching files.

Expected console output:

```text
Total size: 7.9 MB
TXT files found:
- notes.txt (1.2 MB)
- todo.txt (0.5 MB)
```



