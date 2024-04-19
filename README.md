### Hexlet tests and linter status:
[![Actions Status](https://github.com/Rata0/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Rata0/java-project-71/actions)
[![Actions Status](https://github.com/Rata0/java-project-71/actions/workflows/ci-check.yml/badge.svg)](https://github.com/Rata0/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/da0f9386aa130c0e2670/maintainability)](https://codeclimate.com/github/Rata0/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/da0f9386aa130c0e2670/test_coverage)](https://codeclimate.com/github/Rata0/java-project-71/test_coverage)

# Difference Calculator

Difference Calculator is a program designed to determine the difference between two data structures. This utility solves a common problem used in test output or for automatically tracking changes in configuration files.

## Features
- Supports different input formats: YAML and JSON.
- Generates reports in plain text, stylish, and JSON formats.
## Usage

```bash
make run-dist
./build/install/app/bin/app -h
Usage: gendiff [-hV] [-f=<format>] <filepath1> <filepath2>

Compares two configuration files and shows a difference.
<filepath1>         Path to the first file
<filepath2>         Path to the second file

Options:
  -f, --format=<format>   Output format [default: stylish]
  -h, --help              Show this help message and exit.
  -V, --version           Print version information and exit.
```

## Usage Examples

Here are usage examples of the Difference Calculator showcasing different options and input data.

### Example 1: Comparison of two flat JSON files

[![asciicast](https://asciinema.org/a/XspIE3bz2UA4TKGRUDkWIDm0q.svg)](https://asciinema.org/a/XspIE3bz2UA4TKGRUDkWIDm0q)

This example demonstrates the comparison of two flat JSON files using the standard "stylish" output format.

### Example 2: Comparing two flat YAML files

[![asciicast](https://asciinema.org/a/5Oi6XjAMs5Jk48Y5PQlgzKS5N.svg)](https://asciinema.org/a/5Oi6XjAMs5Jk48Y5PQlgzKS5N)

This example shows a comparison of two flat YAML files using the standard "stylish" output format.

### Example 3: Comparing two nested JSON files

[![asciicast](https://asciinema.org/a/eU0qKYQFIOiHOna510ClFk3w3.svg)](https://asciinema.org/a/eU0qKYQFIOiHOna510ClFk3w3)

This example demonstrates comparing two nested JSON files using the standard "stylish" output format.

### Example 4: Comparing Two YAML Files with Custom Output Format

[![asciicast](https://asciinema.org/a/RXSIwhaste9Au2QPJLNHLUlhD.svg)](https://asciinema.org/a/RXSIwhaste9Au2QPJLNHLUlhD)

This shows a comparison of two nested YAML files, specifying a custom output format of "plain". 

### Example 5: Comparing two nested JSON files with Custom Output Format

[![asciicast](https://asciinema.org/a/RZKS8fNblLrpeU1msvyYE8mb4.svg)](https://asciinema.org/a/RZKS8fNblLrpeU1msvyYE8mb4)

This example demonstrates the comparison of two nested JSON files, specifying the custom output format "json". 