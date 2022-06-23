# Bank Account Kata

## Directives
Dans la mesure de votre niveau de séniorité et d'expérience, nous vous proposons de résoudre ce kata avec une architecture hexagonale et en adoptant une routine TDD red/green/refactor. (no frameworks are required, just focus on solving the domain problem)

Le kata est incrémental : en partant des stories, vous implémentez le modèle métier que vous exposez au-travers de ports; dans un 2nd temps, vous développez les adapteurs de l'application.

Vos commits successifs dans Git retranscrivent vos étapes et le cycle TDD red/green/refactor si vous décidez de l'adopter. 

## Etape 1 - Le modèle métier

Dans une 1ère itération, vous implementez le modèle : votre code est orienté métier, simple, efficace et non-anémique.

## Etape 2 - Adapteur API

Vous ajoutez un adapteur Spring qui expose votre application au travers de routes HTTP qui respectent les meilleurs standards d'une REST API.

## Etape 3 - Adapteur de Persistence

Vous ajoutez l'adapteur de persistence de votre choix (SQLlite, H2, ...).


```
## User Stories

In order to implement this Kata, think of your personal bank account experience.
When in doubt, go for the simplest solution Requirements

* Deposit and Withdrawal
* Account statement (date, amount, balance)
* Statement printing
 

## User Story 1

In order to save money

As a bank client

I want to make a deposit in my account


## User Story 2

In order to retrieve some or all of my savings

As a bank client

I want to make a withdrawal from my account


## User Story 3

In order to check my operations

As a bank client

I want to see the history (operation, date, amount, balance) of my operations
```

## Credits
Merci aux craftsmen de la SGIB pour leurs exigences qui nous tirent vers le meilleur.
