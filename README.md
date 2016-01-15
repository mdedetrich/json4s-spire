# json4s-spire: Spire wrappers for Json4s

[json4s-spire][1] is a collection of sane wrappers for basic [spire][2] number types to [json4s][3] Json AST representation, allowing
you to easily decompose spire values to Json and extract Json values into spire values. It is built for scala 2.10 and scala 2.11.

# Installation

Simply add the following dependency to `libraryDependencies`

    "org.mdedetrich" %% "json4s-spire" % "1.1.0"
    
# Usage

[json4s-spire][1] comes with 2 modes, `withDouble` and `withDecimal`. `withDouble` converts `JDouble` to relevant [spire][2] types and vice versa,
where as `withDecimal` converts `JDecimal` to relevant spire types and vice versa

The `implicit val fixedScale` is needed due to the [spire][2] `FixedPoint` type. If you need to change between different `FixedPoint`s, you need
to create a different [json4s][3] `Formats` for each case

## withDecimal

```scala
implicit val fixedScale = FixedScale(10)
val formats = DefaultFormats.withBigDecimal ++ org.json4s.spire.Serializers.withDecimal
```

## withDouble

```scala
implicit val fixedScale = FixedScale(10)
val formats = DefaultFormats.withBigDecimal ++ org.json4s.spire.Serializers.withDouble
```

# TODO

* More non trivial test cases need to be added

[1]:https://github.com/mdedetrich/json4s-spire
[2]:https://github.com/non/spire
[3]:https://github.com/json4s/json4s