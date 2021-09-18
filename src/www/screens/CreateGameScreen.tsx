import { useCallback } from "react";
import { useAppDispatch, useDispatchForm, useInputRef } from "www/store/hooks";
import { gameCreated } from "www/store/game/actions";
import { screenPopped } from "www/widgets/ScreenStackWidget/actions";

export function CreateGameScreen() {
  const gameNameRef = useInputRef();
  const createGame = useDispatchForm(gameCreated, gameNameRef);
  const dispatch = useAppDispatch();
  const cancel = useCallback(() => dispatch(screenPopped()), [dispatch]);

  return (
    <div>
      <h1>Create game!</h1>

      <label>
        Game name
        <input ref={gameNameRef} />
      </label>

      <button onClick={createGame}>Create game</button>
      <button onClick={cancel}>Cancel</button>
    </div>
  );
}
