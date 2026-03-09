# Currency Converter (Spring Boot)

A basic Spring Boot REST application to convert amounts between a small set of currencies.

## Supported currencies
- USD
- EUR
- INR
- GBP
- JPY

## Run locally
```bash
mvn spring-boot:run
```


## Swagger UI
After starting the application, open:
- `http://localhost:8080/swagger-ui.html`

## API
### Convert currency
**POST** `/api/currency/convert`

Request body:
```json
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
```

Example response:
```json
{
  "from": "USD",
  "to": "INR",
  "originalAmount": 100,
  "convertedAmount": 8333.33,
  "exchangeRate": 83.33333333
}
```

## Sync with `main`
To keep your feature branch aligned and avoid merge conflicts:
```bash
git fetch origin
git rebase origin/main
```
If conflicts occur, resolve them and continue:
```bash
git add .
git rebase --continue
```
