# DGS Codegen & interfaces

In this example repo there is a graph with multiple interfaces, two of them extending another interface.
Whilst this is a valid graph, it seems that DGS Codegen doesn't generate all the desired code.

See [query.graphqls](src/main/resources/schema/query.graphqls).

A query like the following give the same result, but only code for the first one is possible with generated code:

As generated with client code (see [Example.kt](src/main/kotlin/com/example/dgscodegeninterfaces/Example.kt))

```graphql
{
  profile {
    id
    accounts {
      ... on PaymentAccount {
        __typename
        balance
        id
        name
      }
      ... on SavingsAccount {
        __typename
        balance
        id
        name
      }
    }
  }
}
```

```graphql
{
  profile {
    id
    accounts {
      ... on Account {
        __typename
        balance
        id
        name
      }
    }
  }
}
```

Of course, if specific fields from a `PaymentAccount` or `SavingsAccount` need to be queried `... on PaymentAccount`, or equivalent, is the only option.

There is no `onAccount` projection generated, even though tools like GraphiQL do.
