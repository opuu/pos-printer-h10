import { registerPlugin } from '@capacitor/core';

import type { POSH10Plugin } from './definitions';

const POSH10 = registerPlugin<POSH10Plugin>('POSH10', {
  web: () => import('./web').then(m => new m.POSH10Web()),
});

export * from './definitions';
export { POSH10 };
