export default function ValidationButton({ isValid, onClick }) {
  return (
    <button disabled={isValid ? true : false} onClick={() => onClick()}>
      Validate student
    </button>
  );
}
