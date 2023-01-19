export interface IOwner {
  id?: number;
  ownerName?: string | null;
  age?: number | null;
}

export const defaultValue: Readonly<IOwner> = {};
