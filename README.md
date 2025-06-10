# capacitor-plugin-pos-h10

Plugin to handle inner printer of Senraise H10

## Install

```bash
npm install capacitor-plugin-pos-h10
npx cap sync
```

## API

<docgen-index>

* [`getServiceVersion(...)`](#getserviceversion)
* [`printText(...)`](#printtext)
* [`printImage(...)`](#printimage)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getServiceVersion(...)

```typescript
getServiceVersion(options: {}) => any
```

| Param         | Type            |
| ------------- | --------------- |
| **`options`** | <code>{}</code> |

**Returns:** <code>any</code>

--------------------


### printText(...)

```typescript
printText(options: { text: string; }) => any
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ text: string; }</code> |

**Returns:** <code>any</code>

--------------------


### printImage(...)

```typescript
printImage(options: { base64: string; }) => any
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ base64: string; }</code> |

**Returns:** <code>any</code>

--------------------

</docgen-api>
