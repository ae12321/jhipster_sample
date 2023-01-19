export interface ICar {
  id?: number;
  carName?: string | null;
  is4Door?: boolean | null;
}

export const defaultValue: Readonly<ICar> = {
  is4Door: false,
};
