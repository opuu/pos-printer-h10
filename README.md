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

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getServiceVersion(...)

```typescript
getServiceVersion(options: {}) => Promise<{ version: string; }>
```

| Param         | Type            |
| ------------- | --------------- |
| **`options`** | <code>{}</code> |

**Returns:** <code>Promise&lt;{ version: string; }&gt;</code>

--------------------


### printText(...)

```typescript
printText(options: { text: string; }) => Promise<void>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ text: string; }</code> |

--------------------

</docgen-api>
