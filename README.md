# PixelCraft

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)

A command-line image processing tool in Java. Each filter is a class that plugs into a small converter framework, so new effects can be added without touching the entry point.

## Filters

| Per-pixel | Spatial |
| --- | --- |
| `Grayscale`, `Sepia`, `Invert`, `Brightness`, `Posterize` | `Blur`, `Rotate`, `FlipRecursive`, `MirrorRecursive` |

## Design

- **`Converter`** (abstract): reads a PNG, calls `process()`, writes the result.
- **`PerPixelConverter`**: maps one ARGB pixel to another, used for colour filters.
- **`RecursiveSpatialConverter`**: walks the image with recursion instead of loops, used for filters that move pixels.
- **`ARGB`**: unpacks and repacks the 32-bit pixel with bit shifts.
- **`PixelCraft`**: loads the requested filter by name with reflection, so the CLI never needs editing when a filter is added.

## Usage

```bash
javac -d out src/*.java
java -cp out PixelCraft Grayscale photo.png   # writes photo_Grayscale.png
```
